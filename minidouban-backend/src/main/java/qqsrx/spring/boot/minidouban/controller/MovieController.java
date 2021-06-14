package qqsrx.spring.boot.minidouban.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qqsrx.spring.boot.minidouban.domain.Movie;
import qqsrx.spring.boot.minidouban.service.MovieService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

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
                json.put("imgsrc", "http://www.yylp.xyz/movie_pic/1.jpg");
                json.put("chName", movie.getChineseName());
                json.put("IMDb", movie.getIMDbId());
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

    @RequestMapping(value="/movies/getmovie/{imdbId}", method=RequestMethod.GET)
    public String getMovieById(@PathVariable(value="imdbId")String imdbId) {
        JSONObject object = new JSONObject();
        try {
            Movie movie = movieService.getMovieById(imdbId);
            JSONObject json = new JSONObject();
            json.put("chName", movie.getChineseName());
            json.put("enName", movie.getEnglishName());
            json.put("mtype", movie.getTypeName());
            json.put("rate", movie.getRate());
            json.put("country", movie.getCountry());
            json.put("date", movie.getReleaseDate());
            json.put("mlen", movie.getDuration());
            json.put("IMDb", movie.getIMDbId());
            System.out.print(movie.getIMDbId());
            object.put("movie", json);
            object.put("code", 20000);
        } catch (Exception e) {
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            object.put("code", -1);
            e.printStackTrace();
        }
        return object.toJSONString();
    }



}
