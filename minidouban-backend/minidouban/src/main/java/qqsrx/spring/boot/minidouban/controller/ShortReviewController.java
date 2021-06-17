package qqsrx.spring.boot.minidouban.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import qqsrx.spring.boot.minidouban.domain.Intention;
import qqsrx.spring.boot.minidouban.domain.Movie;
import qqsrx.spring.boot.minidouban.domain.ShortReview;
import qqsrx.spring.boot.minidouban.service.MovieService;
import qqsrx.spring.boot.minidouban.service.SRLikeService;
import qqsrx.spring.boot.minidouban.service.ShortReviewService;
import qqsrx.spring.boot.minidouban.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ShortReviewController {
    @Autowired
    private ShortReviewService srService;

    @Autowired
    private UserService userService;

    @Autowired
    private SRLikeService srLikeService;

    @Autowired
    private MovieService movieService;

    /**
     * 标记"看过"，发布短评
     * @param request // userId, IMDb, rate, srContent
     * @return
     */
    @RequestMapping(value="/shortreview", method=RequestMethod.POST)
    public String add(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int userId =  Integer.parseInt(request.getParameter("userId"));
        String imdbId = request.getParameter("IMDb");
        int rate = Integer.parseInt(request.getParameter("rate"));
        String srContent = request.getParameter("srContent");

        ShortReview sr = new ShortReview(imdbId, userId, rate, srContent);

        try{
            int req = srService.add(sr);
            if(req<0){
                object.put("code", 0);
                object.put("result", "add failed");
            }else{
                object.put("code", 20000);
                object.put("result", "add succeeded");
            }
        } catch(Exception e){
            object.put("code", -1);
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return object.toJSONString();
    }

    /**
     * 删除短评
     * @param request // userId, IMDb
     * @return
     */
    @RequestMapping(value="/shortreview/delete", method=RequestMethod.DELETE)
    public String delete(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int userId =  Integer.parseInt(request.getParameter("userId"));
        String imdbId = request.getParameter("IMDb");

        try{
            int req = srService.delete(imdbId, userId);
            if(req<0){
                object.put("code", 0);
                object.put("result", "delete failed");
            }else{
                object.put("code", 20000);
                object.put("result", "delete succeeded");
            }
        } catch(Exception e){
            object.put("code", -1);
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return object.toJSONString();
    }

    /**
     * 更新短评
     * @param request // userId, IMDb, rate, srContent
     * @return
     */
    @RequestMapping(value="/shortreview/update", method=RequestMethod.PUT)
    public String update(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int userId =  Integer.parseInt(request.getParameter("userId"));
        String imdbId = request.getParameter("IMDb");
        int rate = Integer.parseInt(request.getParameter("rate"));
        String srContent = request.getParameter("srContent");

        ShortReview sr = new ShortReview(imdbId, userId, rate, srContent);

        try{
            int req = srService.update(imdbId, userId, sr);
            if(req<0){
                object.put("code", 0);
                object.put("result", "update failed");
            }else{
                object.put("code", 20000);
                object.put("result", "update succeeded");
            }
        } catch(Exception e){
            object.put("code", -1);
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return object.toJSONString();
    }

    /**
     * 根据IMDbId获取该电影的所有短评
     * @param request // IMDb
     * @return
     */
    @RequestMapping(value="/shortreview/getsrbyIMDb", method=RequestMethod.GET)
    public String getSRListByIMDbId(HttpServletRequest request) {
        JSONObject object = new JSONObject();
        String imdbId = request.getParameter("IMDb");
        try{
            List<ShortReview> srList = srService.getSRListByIMDbId(imdbId);
            List<JSONObject> jsonList = new ArrayList<>();
            for(ShortReview sr: srList){
                JSONObject json = new JSONObject();
                json.put("userId", sr.getUserId());
                json.put("username", userService.getUserById(sr.getUserId()).getUserName());
                json.put("rate", sr.getRate());
                json.put("srContent", sr.getSrContent());
                json.put("imgsrc", "http://www.yylp.xyz/res/avatars/" + sr.getUserId() + ".jpg");
                json.put("srLikeSum", srLikeService.getSRLikeSum(sr.getImdbId(), sr.getUserId()));

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                json.put("postTime", sdf.format(sr.getSrPostTime()));

                jsonList.add(json);
            }
            object.put("shortreviewlist", jsonList);
            object.put("IMDb", imdbId);
            object.put("code", 20000);
        }catch (Exception e){
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            object.put("code", -1);
            e.printStackTrace();
        }
        return object.toJSONString();
    }

    /**
     * 判断是否标记看过一个电影
     * @param request // userId, IMDb
     * @return
     */
    @RequestMapping(value="/haswatched", method=RequestMethod.GET)
    public String hasWatched(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int userId = Integer.parseInt(request.getParameter("userId"));
        String imdbId = request.getParameter("IMDb");

        try{
            boolean hasWatched = srService.hasWatched(imdbId, userId);
            object.put("hasWatched", hasWatched);
            object.put("code", 20000);
        }catch(Exception e){
            object.put("code", -1);
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return object.toJSONString();
    }

    /**
     * 获得用户标记"看过"的电影信息
     * @param request // userId
     * @return
     */
    @RequestMapping(value="/shortreview/showusersr", method=RequestMethod.GET)
    public String showUserIntention(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int userId = Integer.parseInt(request.getParameter("userId"));

        try{
            List<ShortReview> userSRs = srService.getSRListByUserId(userId);
            List<JSONObject> movieList = new ArrayList<>();

            for(ShortReview sr: userSRs){
                JSONObject movieJson = new JSONObject();
                Movie movie = movieService.getMovieById(sr.getImdbId());
                movieJson.put("posterURL", "http://www.yylp.xyz/res/posters/"+ sr.getImdbId() +".jpg");
                movieJson.put("chName", movie.getChineseName());
                movieJson.put("enName", movie.getEnglishName());
                movieJson.put("mtype", movie.getTypeName());
                movieJson.put("rate", String.valueOf(movie.getRate()));
                movieJson.put("country", movie.getCountry());
                movieJson.put("date", movie.getReleaseDate());
                movieJson.put("mlen", movie.getDuration());
                movieJson.put("IMDb", movie.getIMDbId());
                movieJson.put("intro", movie.getMovieIntroduction());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                movieJson.put("postTime", sdf.format(sr.getSrPostTime()));
                movieJson.put("rate", sr.getRate());
                movieJson.put("srContent", sr.getSrContent());

                movieList.add(movieJson);
            }
            object.put("shortReviews", movieList);
            object.put("code", 20000);
        }catch(Exception e){
            object.put("code", -1);
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return object.toJSONString();
    }
}
