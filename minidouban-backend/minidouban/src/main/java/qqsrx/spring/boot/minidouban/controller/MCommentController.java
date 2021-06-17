package qqsrx.spring.boot.minidouban.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import qqsrx.spring.boot.minidouban.domain.MComment;
import qqsrx.spring.boot.minidouban.domain.MomentLike;
import qqsrx.spring.boot.minidouban.service.MCommentService;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class MCommentController {
    @Autowired
    private MCommentService mCommentService;

    /**
     * 添加一条回复
     * @param request // momentId, fromId, toId, content
     * @return
     */
    @RequestMapping(value="/comment", method= RequestMethod.POST)
    public String add(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int momentId =  Integer.parseInt(request.getParameter("momentId"));
        int userId =  Integer.parseInt(request.getParameter("fromId"));
        int toUserId = Integer.parseInt(request.getParameter("toId"));
        String commentContent = request.getParameter("content");

        MComment mComment = new MComment(momentId, userId, toUserId, commentContent);

        try{
            int req = mCommentService.add(mComment);
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

}
