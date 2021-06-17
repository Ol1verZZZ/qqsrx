package qqsrx.spring.boot.minidouban.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import qqsrx.spring.boot.minidouban.domain.Artist;
import qqsrx.spring.boot.minidouban.domain.Movie;
import qqsrx.spring.boot.minidouban.service.ArtistService;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    /**
     * 根据imbdId查询Artist
     * @param request // imdbId
     * @return
     */
    @RequestMapping(value="/artists/getartist", method= RequestMethod.GET)
    public String getArtistById(HttpServletRequest request) {
        String imdbArtistId = request.getParameter("IMDb");
        JSONObject object = new JSONObject();
        try {
            Artist artist = artistService.getArtistById(imdbArtistId);
            JSONObject json = new JSONObject();
            json.put("IMDb", artist.getImdbArtistId());
            json.put("gender", artist.getGender());
            json.put("chName", artist.getChineseName());
            json.put("enName", artist.getForeignName());
            json.put("birthDate", artist.getBirthDate());
            json.put("birthPlace", artist.getBirthPlace());
            json.put("intro", artist.getArtistIntroduction());

            object.put("artist", json);
            object.put("code", 20000);
        } catch(Exception e) {
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            object.put("code", -1);
            e.printStackTrace();
        }
        return object.toJSONString();
    }
}
