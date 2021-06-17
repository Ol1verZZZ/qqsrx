package qqsrx.spring.boot.minidouban.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import qqsrx.spring.boot.minidouban.domain.Intention;
import qqsrx.spring.boot.minidouban.domain.MComment;
import qqsrx.spring.boot.minidouban.domain.Moment;
import qqsrx.spring.boot.minidouban.domain.MomentLike;
import qqsrx.spring.boot.minidouban.service.MCommentService;
import qqsrx.spring.boot.minidouban.service.MomentLikeService;
import qqsrx.spring.boot.minidouban.service.MomentService;
import qqsrx.spring.boot.minidouban.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class MomentController {
    @Autowired
    private MomentService momentService;

    @Autowired
    private UserService userService;

    @Autowired
    private MomentLikeService momentLikeService;

    @Autowired
    private MCommentService mCommentService;

    /**
     * 发布一条动态
     * @param request // userId, momentContent
     * @return
     */
    @RequestMapping(value="/moment", method= RequestMethod.POST)
    public String add(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int userId =  Integer.parseInt(request.getParameter("userId"));
        String momentContent = request.getParameter("momentContent");

        Moment moment = new Moment(userId, momentContent);

        try{
            int req = momentService.add(moment);
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
     * 获取所有动态及其回复
     * @return
     */
    @RequestMapping(value="/moment/getallmoments", method=RequestMethod.GET)
    public String getAllMoments() {
        JSONObject object = new JSONObject();

        try{
            List<Moment> moments = momentService.getAllMoments();
            List<JSONObject> momentList = new ArrayList<>();

            for(Moment moment: moments){
                JSONObject momentJson = new JSONObject();
                momentJson.put("momentId", moment.getMomentId());
                momentJson.put("ownerId", moment.getUserId());
                momentJson.put("ownerName", userService.getUserById(moment.getUserId()).getUserName());
                momentJson.put("ownerAvatar", "http://www.yylp.xyz/res/avatars/"+moment.getUserId()+".jpg");
                momentJson.put("content", moment.getMomentContent());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                momentJson.put("postTime", sdf.format(moment.getMomentPostTime()));

                momentJson.put("likeSum", momentLikeService.getMomentLikeSum(moment.getMomentId()));

                if(mCommentService.getCommentListByMId(moment.getMomentId())!=null&&
                        mCommentService.getCommentListByMId(moment.getMomentId()).size()>0){
                    List<MComment> comments = mCommentService.getCommentListByMId(moment.getMomentId());
                    List<JSONObject> commentList = new ArrayList<>();
                    for(MComment comment: comments) {
                        JSONObject commentJson = new JSONObject();
                        commentJson.put("comment_id", comment.getCommentId());
                        commentJson.put("moment_id", comment.getMomentId());
                        commentJson.put("fromId", comment.getUserId());
                        commentJson.put("fromName", userService.getUserById(comment.getUserId()).getUserName());
                        commentJson.put("fromAvatar", "http://www.yylp.xyz/res/avatars/"+comment.getUserId()+".jpg");
                        commentJson.put("toId", comment.getToUserId());
                        commentJson.put("toName", userService.getUserById(comment.getToUserId()).getUserName());
                        commentJson.put("toAvatar", "http://www.yylp.xyz/res/avatars/"+comment.getToUserId()+".jpg");
                        commentJson.put("content", comment.getCommentContent());

                        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        commentJson.put("commentTime", sdf2.format(comment.getCommentTime()));

                        commentList.add(commentJson);
                    }
                    momentJson.put("comment", commentList);
                }
                momentList.add(momentJson);
            }
            object.put("moment", momentList);
            object.put("code", 20000);
        }catch(Exception e) {
            object.put("code", -1);
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return object.toJSONString();
    }

    /**
     * 根据UserId获取某用户的动态及回复
     * @param request // userId
     * @return
     */
    @RequestMapping(value="/moment/getmomentlistbyuserid", method=RequestMethod.GET)
    public String getMomentListByUserId(HttpServletRequest request) {
        JSONObject object = new JSONObject();
        int userId =  Integer.parseInt(request.getParameter("userId"));

        try{
            List<Moment> moments = momentService.getMomentListByUserId(userId);
            List<JSONObject> momentList = new ArrayList<>();

            for(Moment moment: moments){
                JSONObject momentJson = new JSONObject();
                momentJson.put("momentId", moment.getMomentId());
                momentJson.put("ownerId", moment.getUserId());
                momentJson.put("ownerName", userService.getUserById(moment.getUserId()).getUserName());
                momentJson.put("ownerAvatar", "http://www.yylp.xyz/res/avatars/"+moment.getUserId()+".jpg");
                momentJson.put("content", moment.getMomentContent());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                momentJson.put("postTime", sdf.format(moment.getMomentPostTime()));

                momentJson.put("likeSum", momentLikeService.getMomentLikeSum(moment.getMomentId()));

                if(mCommentService.getCommentListByMId(moment.getMomentId())!=null&&
                        mCommentService.getCommentListByMId(moment.getMomentId()).size()>0){
                    List<MComment> comments = mCommentService.getCommentListByMId(moment.getMomentId());
                    List<JSONObject> commentList = new ArrayList<>();
                    for(MComment comment: comments) {
                        JSONObject commentJson = new JSONObject();
                        commentJson.put("comment_id", comment.getCommentId());
                        commentJson.put("moment_id", comment.getMomentId());
                        commentJson.put("fromId", comment.getUserId());
                        commentJson.put("fromName", userService.getUserById(comment.getUserId()).getUserName());
                        commentJson.put("fromAvatar", "http://www.yylp.xyz/res/avatars/"+comment.getUserId()+".jpg");
                        commentJson.put("toId", comment.getToUserId());
                        commentJson.put("toName", userService.getUserById(comment.getToUserId()).getUserName());
                        commentJson.put("toAvatar", "http://www.yylp.xyz/res/avatars/"+comment.getToUserId()+".jpg");
                        commentJson.put("content", comment.getCommentContent());

                        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        commentJson.put("commentTime", sdf2.format(comment.getCommentTime()));

                        commentList.add(commentJson);
                    }
                    momentJson.put("comment", commentList);
                }
                momentList.add(momentJson);
            }
            object.put("moment", momentList);
            object.put("code", 20000);
        }catch(Exception e) {
            object.put("code", -1);
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return object.toJSONString();
    }
}
