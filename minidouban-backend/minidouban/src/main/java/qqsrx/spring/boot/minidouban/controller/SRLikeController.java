package qqsrx.spring.boot.minidouban.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import qqsrx.spring.boot.minidouban.domain.Intention;
import qqsrx.spring.boot.minidouban.domain.SRLike;
import qqsrx.spring.boot.minidouban.service.SRLikeService;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class SRLikeController {
    @Autowired
    private SRLikeService srLikeService;

    /**
     * 喜欢一个短评
     * @param request // ownerId, IMDb, userId
     * @return
     */
    @RequestMapping(value="/srlike", method= RequestMethod.POST)
    public String add(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int ownerId =  Integer.parseInt(request.getParameter("ownerId"));
        String imdbId = request.getParameter("IMDb");
        int userId =  Integer.parseInt(request.getParameter("userId"));

        SRLike srLike = new SRLike(ownerId, imdbId, userId);

        try{
            int req = srLikeService.add(srLike);
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
     * 取消对一个短评的喜欢
     * @param request // ownerId, IMDb, userId
     * @return
     */
    @RequestMapping(value="/srlike/cancel", method=RequestMethod.DELETE)
    public String delete(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int ownerId =  Integer.parseInt(request.getParameter("ownerId"));
        String imdbId = request.getParameter("IMDb");
        int userId =  Integer.parseInt(request.getParameter("userId"));

        try{
            int req = srLikeService.delete(imdbId, ownerId, userId);
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
     * 获得某一评论的点赞总数
     * @param request // ownerId, IMDb
     * @return
     */
    @RequestMapping(value="/srlike/getsrlikesum", method=RequestMethod.GET)
    public String getSRLikeSum(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int ownerId =  Integer.parseInt(request.getParameter("ownerId"));
        String imdbId = request.getParameter("IMDb");

        try{
            int srLikeSum = srLikeService.getSRLikeSum(imdbId, ownerId);
            object.put("code", 20000);
            object.put("srLikeSum", String.valueOf(srLikeSum));
        }catch(Exception e){
            object.put("code", -1);
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return object.toJSONString();
    }

    /**
     * 判断是否点赞过一个评论
     * @param request // ownerId, IMDb, userId
     * @return
     */
    @RequestMapping(value="/srlike/hasliked", method=RequestMethod.GET)
    public String hasLiked(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int ownerId = Integer.parseInt(request.getParameter("ownerId"));
        String imdbId = request.getParameter("IMDb");
        int userId = Integer.parseInt(request.getParameter("userId"));

        try{
            boolean hasLiked = srLikeService.hasLiked(imdbId, ownerId, userId);
            object.put("hasLiked", hasLiked);
            object.put("code", 20000);
        }catch(Exception e){
            object.put("code", -1);
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return object.toJSONString();
    }
}
