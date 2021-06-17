package qqsrx.spring.boot.minidouban.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import qqsrx.spring.boot.minidouban.domain.Friendship;
import qqsrx.spring.boot.minidouban.domain.Intention;
import qqsrx.spring.boot.minidouban.service.FriendshipService;
import qqsrx.spring.boot.minidouban.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class FriendshipController {
    @Autowired
    private FriendshipService friendshipService;

    @Autowired
    private UserService userService;

    /**
     * 关注一个用户
     * @param request // fromId, toId
     * @return
     */
    @RequestMapping(value="/friendship/follow", method= RequestMethod.POST)
    public String add(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int fromId =  Integer.parseInt(request.getParameter("fromId"));
        int toId =  Integer.parseInt(request.getParameter("toId"));

        Friendship friendship = new Friendship(fromId, toId);

        try{
            int req = friendshipService.add(friendship);
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
     * 取消对一个用户的关注
     * @param request // fromId, toId
     * @return
     */
    @RequestMapping(value="/friendship/cancel", method= RequestMethod.DELETE)
    public String delete(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int fromId =  Integer.parseInt(request.getParameter("fromId"));
        int toId =  Integer.parseInt(request.getParameter("toId"));

        try{
            int req = friendshipService.delete(fromId, toId);
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
     * 获得某用户的关注列表
     * @param request // fromId
     * @return
     */
    @RequestMapping(value="/friendship/getfollowinglist", method= RequestMethod.GET)
    public String getFollowingList(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int fromId = Integer.parseInt(request.getParameter("fromId"));

        try{
            List<JSONObject> friendshipList = new ArrayList<>();
            List<Friendship> friendships = friendshipService.getFollowingList(fromId);
            if(friendships!=null&&friendships.size()>0){
                for(Friendship friendship: friendships){
                    JSONObject friendshipJson = new JSONObject();

                    friendshipJson.put("userId", friendship.getToId());
                    friendshipJson.put("name", userService.getUserById(friendship.getToId()).getUserName());
                    friendshipJson.put("email", userService.getUserById(friendship.getToId()).getEmail());
                    friendshipJson.put("avatar", "http://www.yylp.xyz/res/avatars/" + friendship.getToId() + ".jpg");
                    friendshipList.add(friendshipJson);
                }
            }
            object.put("followingList", friendshipList);
            object.put("code", 20000);
        }catch(Exception e){
            object.put("code", -1);
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return object.toJSONString();
    }

    /**
     * 获得某用户的粉丝列表
     * @param request // toId
     * @return
     */
    @RequestMapping(value="/friendship/getfollowedlist", method= RequestMethod.GET)
    public String getFollowedList(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        int toId = Integer.parseInt(request.getParameter("toId"));

        try{
            List<JSONObject> friendshipList = new ArrayList<>();
            List<Friendship> friendships = friendshipService.getFollowedList(toId);
            if(friendships!=null&&friendships.size()>0){
                for(Friendship friendship: friendships){
                    JSONObject friendshipJson = new JSONObject();

                    friendshipJson.put("userId", friendship.getFromId());
                    friendshipJson.put("name", userService.getUserById(friendship.getFromId()).getUserName());
                    friendshipJson.put("email", userService.getUserById(friendship.getFromId()).getEmail());
                    friendshipJson.put("avatar", "http://www.yylp.xyz/res/avatars/" + friendship.getFromId() + ".jpg");
                    friendshipList.add(friendshipJson);
                }
            }
            object.put("followedList", friendshipList);
            object.put("code", 20000);
        }catch(Exception e){
            object.put("code", -1);
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return object.toJSONString();
    }
}
