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
import qqsrx.spring.boot.minidouban.service.IntentionService;
import qqsrx.spring.boot.minidouban.service.MovieService;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class IntentionController {
    @Autowired
    private IntentionService intentionService;

    @Autowired
    private MovieService movieService;

    /**
     * 添加"想看"
     * @param request // userId, IMDb, description
     * @return
     */
    @RequestMapping(value="/intention", method=RequestMethod.POST)
    public String add(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int userId =  Integer.parseInt(request.getParameter("userId"));
        String imdbId = request.getParameter("IMDb");
        String markDescription = request.getParameter("description");

        Intention intention = new Intention(userId, imdbId, markDescription);

        try{
            int req = intentionService.add(intention);
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
     * 删除"想看"
     * @param request // userId, IMDb
     * @return
     */
    @RequestMapping(value="/intention/delete", method=RequestMethod.DELETE)
    public String delete(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int userId =  Integer.parseInt(request.getParameter("userId"));
        String imdbId = request.getParameter("IMDb");

        try{
            int req = intentionService.delete(userId, imdbId);
            if(req<0){
                object.put("code", 0);
                object.put("result", "delete failed");
            }else{
                object.put("code", 20000);
                object.put("result", "delete succeeded");
            }
        }catch(Exception e) {
            object.put("code", -1);
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return object.toJSONString();
    }

    /**
     * 判断是否想看过一个电影
     * @param request // userId, IMDb
     * @return
     */
    @RequestMapping(value="/intention/hasintention", method=RequestMethod.GET)
    public String hasIntention(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int userId = Integer.parseInt(request.getParameter("userId"));
        String imdbId = request.getParameter("IMDb");

        try{
            boolean hasIntention = intentionService.hasIntention(userId, imdbId);
            object.put("hasIntention", hasIntention);
            object.put("code", 20000);
        }catch(Exception e){
            object.put("code", -1);
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return object.toJSONString();
    }

    /**
     * 获得用户标记"想看"的电影信息
     * @param request // userId
     * @return
     */
    @RequestMapping(value="/intention/showuserintention", method=RequestMethod.GET)
    public String showUserIntention(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int userId = Integer.parseInt(request.getParameter("userId"));

        try{
            List<JSONObject> movieList = new ArrayList<>();
            if(intentionService.getIntentionListByUserId(userId)!=null&&
                    intentionService.getIntentionListByUserId(userId).size()>0){
                List<Intention> userIntentions = intentionService.getIntentionListByUserId(userId);
                for(Intention intention: userIntentions){
                    JSONObject movieJson = new JSONObject();
                    Movie movie = movieService.getMovieById(intention.getImdbId());
                    movieJson.put("posterURL", "http://www.yylp.xyz/res/posters/" + intention.getImdbId() + ".jpg");
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
                    movieJson.put("markTime", sdf.format(intention.getMarkTime()));
                    movieList.add(movieJson);
                }
            }
            object.put("intentions", movieList);
            object.put("code", 20000);
        }catch(Exception e){
            object.put("code", -1);
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return object.toJSONString();
    }
}
