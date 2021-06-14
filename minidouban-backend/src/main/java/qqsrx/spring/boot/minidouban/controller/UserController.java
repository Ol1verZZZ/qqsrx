package qqsrx.spring.boot.minidouban.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qqsrx.spring.boot.minidouban.domain.JsonResult;
import qqsrx.spring.boot.minidouban.domain.User;
import qqsrx.spring.boot.minidouban.service.UserService;

import javax.xml.ws.Response;
import java.util.List;

@RestController
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
    public ResponseEntity<JsonResult> getUserList(){
        JsonResult r = new JsonResult();
        try {
            List<User> users = userService.getUserList();
            r.setResult(users);
            r.setStatus("ok");
        } catch(Exception e) {
            r.setResult(e.getClass().getName() + ": " + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加用户
     * @param user
     * @return

     * @requestBody注解常用来处理content-type不是默认的application/x-www-form-urlcoded编码的内容，
     * 比如说：application/json或者是application/xml等。一般情况下来说常用其来处理application/json类型。
     * 就是从json中提取数据  参见：https://www.cnblogs.com/qiankun-site/p/5774300.html
     */
    @RequestMapping(value="/user", method=RequestMethod.POST)
    public ResponseEntity<JsonResult> add(@RequestBody User user) {
        JsonResult r = new JsonResult();
        try {
            int req = userService.add(user);
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
}
