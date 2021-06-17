package qqsrx.spring.boot.minidouban.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qqsrx.spring.boot.minidouban.domain.JsonResult;
import qqsrx.spring.boot.minidouban.domain.User;
import qqsrx.spring.boot.minidouban.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据ID查询用户
     * @param userId
     * @return
     */
    @RequestMapping(value="/user/{userId}", method=RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserById(@PathVariable(value="userId")Integer userId) {
        JsonResult r = new JsonResult();
        try {
            User user = userService.getUserById(userId);
            r.setResult(user);
            r.setStatus("ok");
        } catch(Exception e) {
            r.setResult(e.getClass().getName() + ": " + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 查询用户列表
     * @return
     */
    @RequestMapping(value="/users", method=RequestMethod.GET)
//    @RequestMapping("/users")
//    public String getUserList() {
//        String s = "fuck";
//        return s;
//    }
    public String getUserList(){
        JSONObject object = new JSONObject();

        try{
            List<User> users = userService.getUserList();
            List<JSONObject> userList = new ArrayList<>();

            if(users!=null&&users.size()>0){
                for(User user: users){
                    JSONObject userJson = new JSONObject();
                    userJson.put("userId", user.getUserId());
                    userJson.put("userName", user.getUserName());
                    userJson.put("password", user.getPassword());
                    userJson.put("gender", user.getGender());
                    userJson.put("registerDate", user.getRegisterDate());
                    userJson.put("isAdmin", user.getIsAdmin());
                    userJson.put("avatar", "http://www.yylp.xyz/res/avatars/" + user.getUserId() + ".jpg");
                    userList.add(userJson);
                }
            }
            object.put("userList", userList);
            object.put("code", 20000);
        }catch(Exception e){
            object.put("code", -1);
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return object.toJSONString();
    }

    /**
     * 注册账号
     * @param request // email, username, password, gender
     * @return
     */
    @RequestMapping(value="/user/register", method=RequestMethod.POST)
    public ResponseEntity<JsonResult> add(HttpServletRequest request) {
        String email = request.getParameter("email");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");

        User user = new User(email, userName, password, gender);

        JsonResult r = new JsonResult();
        try {
            if(userService.getUserByEmail(email)!=null){
                r.setResult("邮箱已被使用");
                r.setStatus("fail");
            }else{
                int req = userService.add(user);
                if(req<0) {
                    r.setResult(req);
                    r.setStatus("fail");
                } else {
                    r.setResult(req);
                    r.setStatus("ok");
                }
            }
        } catch(Exception e) {
            r.setResult(e.getClass().getName() + ": " + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据id删除用户
     * @param userId
     * @return
     */
    @RequestMapping(value="/user/{userId}", method=RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete(@PathVariable(value="userId")Integer userId) {
        JsonResult r = new JsonResult();
        try {
            int req = userService.delete(userId);
            if(req<0) {
                r.setResult(req);
                r.setStatus("fail");
            } else {
                r.setResult(req);
                r.setStatus("ok");
            }
        } catch(Exception e) {
            r.setResult(e.getClass().getName() + ": " + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据id修改用户信息
     * @param userId, user
     * @return
     */
    @RequestMapping(value="/user/{userId}", method=RequestMethod.PUT)
    public ResponseEntity<JsonResult> update(@PathVariable(value="userId")Integer userId, @RequestBody User user) {
        JsonResult r = new JsonResult();
        try {
            int req = userService.update(userId, user);
            if(req<0) {
                r.setResult(req);
                r.setStatus("fail");
            } else {
                r.setResult(req);
                r.setStatus("ok");
            }
        } catch(Exception e) {
            r.setResult(e.getClass().getName() + ": " + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 用户登录
     * @param request // email, password
     * @return
     */
    @RequestMapping(value="/user/login", method=RequestMethod.GET)
    public String logIn(HttpServletRequest request) {
        JSONObject object = new JSONObject();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try{
            boolean logIn = userService.logIn(email, password);
            object.put("login", logIn);
            object.put("code", 20000);
        }catch(Exception e){
            object.put("code", -1);
            object.put("result", e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return object.toJSONString();
    }
}
