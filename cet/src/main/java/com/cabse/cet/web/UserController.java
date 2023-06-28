package com.cabse.cet.web;

import com.cabse.cet.dao.UserDao;
import com.cabse.cet.entity.User;
import com.cabse.cet.service.UserService;
import com.cabse.cet.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: UserController
 * @PackageName:com.cabse.cet.web
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/5/21 20:22
 * @Version 1.0.0
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private UserDao userDao;

    @PostMapping("/login")
    public Result<User> loginController(@RequestParam String username, @RequestParam String password){
        User user = userService.loginService(username, password);
        if (user != null && user.getState() != -1){
            return Result.success(user, "Login success!");
        }else if(user != null && user.getState() == -1){
            return Result.error("102", "Fail. User is frozen!");
        }else{
            return Result.error("100", "Username or password is wrong!");
        }
    }

    @PostMapping("/register")
    public Result<User> registController(@RequestBody User newUser){
        User user = userService.registService(newUser);

        if(user!=null){
            return Result.success(user,"Sign up success!");
        }else{
            return Result.error("101","Fail. User has existed!");
        }
    }

    @PostMapping("/finduser")
    public Result<User> findUser(@RequestParam Integer uid){
        User user = userDao.findByUid(uid);
        if(user!=null){
            return Result.success(user,"success!");
        }else{
            return Result.error("101","Fail. User not existed!");
        }
    }

}
