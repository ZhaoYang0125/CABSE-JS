package com.cabse.cet.web;

import com.cabse.cet.entity.Admin;
import com.cabse.cet.entity.User;
import com.cabse.cet.service.AdminService;
import com.cabse.cet.service.UserService;
import com.cabse.cet.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: AdminController
 * @PackageName:com.cabse.cet.web
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/6/2 17:33
 * @Version 1.0.0
 */

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @PostMapping("/login")
    public Result<Admin> loginController(@RequestParam String username, @RequestParam String password, @RequestParam String token){
        Admin admin = adminService.loginService(username, password, token);
        if (admin != null && admin.getState() != -1){
            return Result.success(admin, "Login success!");
        }else if(admin != null && admin.getState() == -1){
            return Result.error("102", "Fail. User is frozen!");
        }else{
            return Result.error("100", "Username or password is wrong!");
        }
    }

//    @PostMapping("/register")
//    public Result<Admin> registController(@RequestBody Admin newAdmin){
//        Admin admin = adminService.registService(newAdmin);
//
//        if(admin!=null){
//            return Result.success(admin,"Sign up success!");
//        }else{
//            return Result.error("101","Fail. User has existed!");
//        }
//    }
}
