package qqsrx.spring.boot.minidouban.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qqsrx.spring.boot.minidouban.domain.Casting;
import qqsrx.spring.boot.minidouban.domain.Movie;
import qqsrx.spring.boot.minidouban.service.ArtistService;
import qqsrx.spring.boot.minidouban.service.CastingService;
import qqsrx.spring.boot.minidouban.service.MovieService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private CastingService castingService;

    @Autowired
    private ArtistService artistService;

    /**
     * 查询热门电影
     * @return
     */
    @RequestMapping(value="/movies/gethotmovlist", method=RequestMethod.GET)
    public String getHotMovieList() {
        JSONObject object = new JSONObject();
//        List<String> list = new ArrayList<>();
//        list.add("list1");
//        list.add("list2");
//
//        JSONObject json = new JSONObject();
//        json.put("list", list);
//        json.put("status", 1);
//        json.put("resp+code", 200);
//
//        JSONObject json2 = new JSONObject();
//        json2.put("data", json);
//        json2.put("t", 2);
        try {
            List<Movie> movies = movieService.getHotMovieList();
            List<JSONObject> jsonList = new ArrayList<>();
            for(Movie movie: movies) {
                JSONObject json = new JSONObject();
                json.put("imgsrc", "http://www.yylp.xyz/res/posters/" + movie.getIMDbId() + ".jpg");
                json.put("chName", movie.getChineseName());
                json.put("enName", movie.getEnglishName());
                json.put("IMDb", movie.getIMDbId());
                json.put("mtype", movie.getTypeName());
                json.put("rate", String.valueOf(movie.getRate()));
                json.put("country", movie.getCountry());
                json.put("date", movie.getReleaseDate());
                json.put("mlen", movie.getDuration());
                json.put("intro", movie.getMovieIntroduction());
                jsonList.add(json);
            }
            object.put("hotmovlist", jsonList);
            object.put("code", 20000);
        } catch(Exception e) {
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            object.put("code", -1);
            e.printStackTrace();
        }
        return object.toJSONString();
    }

    /**
     * 根据imbdId查询电影
     * @param request // IMDb
     * @return
     */
    @RequestMapping(value="/movies/getmovie", method=RequestMethod.GET)
    public String getMovieById(HttpServletRequest request) {
        String imdbId = request.getParameter("IMDb");
        JSONObject object = new JSONObject();
        try {
            Movie movie = movieService.getMovieById(imdbId);
            List<Casting> castingList = castingService.getCastingListByIMDb(imdbId);
            List<JSONObject> artistList = new ArrayList<>();
            List<String> imgList = new ArrayList<>();
            JSONObject json = new JSONObject();
            json.put("posterURL", "http://www.yylp.xyz/res/posters/" + movie.getIMDbId() + ".jpg");
            json.put("chName", movie.getChineseName());
            json.put("enName", movie.getEnglishName());
            json.put("mtype", movie.getTypeName());
            json.put("rate", String.valueOf(movie.getRate()));
            json.put("country", movie.getCountry());
            json.put("date", movie.getReleaseDate());
            json.put("mlen", movie.getDuration());
            json.put("IMDb", movie.getIMDbId());
            json.put("intro", movie.getMovieIntroduction());

            for(Casting casting: castingList){
                JSONObject artistJson = new JSONObject();

                artistJson.put("IMDb", casting.getImdbArtistId());
                artistJson.put("role", casting.getRole());
                artistJson.put("chName", artistService.getArtistById(casting.getImdbArtistId()).getChineseName());
                artistJson.put("imgsrc", "http://www.yylp.xyz/res/actors/" + casting.getImdbArtistId() +".webp");
            }
            json.put("actor_list", artistList);

            for(int i=1; i<=6; i++){
                imgList.add("http://www.yylp.xyz/res/" + movie.getIMDbId() + "/" + i + ".jpg");
            }
            json.put("img_list", imgList);

            object.put("movie", json);
            object.put("code", 20000);
        } catch(Exception e) {
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            object.put("code", -1);
            e.printStackTrace();
        }
        return object.toJSONString();
    }
}
