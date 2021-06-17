package qqsrx.spring.boot.minidouban.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import qqsrx.spring.boot.minidouban.domain.MomentLike;
import qqsrx.spring.boot.minidouban.domain.SRLike;
import qqsrx.spring.boot.minidouban.service.MomentLikeService;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class MomentLikeController {
    @Autowired
    private MomentLikeService momentLikeService;

    /**
     * 点赞一个动态
     * @param request // userId, momentId
     * @return
     */
    @RequestMapping(value="/momentlike", method= RequestMethod.POST)
    public String add(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int userId =  Integer.parseInt(request.getParameter("userId"));
        int momentId =  Integer.parseInt(request.getParameter("momentId"));

        MomentLike momentLike = new MomentLike(userId, momentId);

        try{
            int req = momentLikeService.add(momentLike);
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
     * 取消对一个动态的点赞
     * @param request // userId, momentId
     * @return
     */
    @RequestMapping(value="/momentlike/cancel", method=RequestMethod.DELETE)
    public String delete(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int userId =  Integer.parseInt(request.getParameter("userId"));
        int momentId =  Integer.parseInt(request.getParameter("momentId"));

        try{
            int req = momentLikeService.delete(userId, momentId);
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
     * 获得某一动态的点赞总数
     * @param request // momentId
     * @return
     */
    @RequestMapping(value="/momentlike/getmlikesum", method=RequestMethod.GET)
    public String getSRLikeSum(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int momentId =  Integer.parseInt(request.getParameter("momentId"));

        try{
            int mLikeSum = momentLikeService.getMomentLikeSum(momentId);
            object.put("code", 20000);
            object.put("momentLikeSum", String.valueOf(mLikeSum));
        }catch(Exception e){
            object.put("code", -1);
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return object.toJSONString();
    }

    /**
     * 判断是否点赞过一个动态
     * @param request // userId, momentId
     * @return
     */
    @RequestMapping(value="/momentlike/hasliked", method=RequestMethod.GET)
    public String hasLiked(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int userId =  Integer.parseInt(request.getParameter("userId"));
        int momentId =  Integer.parseInt(request.getParameter("momentId"));

        try{
            boolean hasLiked = momentLikeService.hasLiked(userId, momentId);
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
