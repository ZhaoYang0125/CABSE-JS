package com.cabse.cet.web;

import com.cabse.cet.entity.Teacher;
import com.cabse.cet.entity.User;
import com.cabse.cet.service.TeacherService;
import com.cabse.cet.service.UserService;
import com.cabse.cet.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: TeacherController
 * @PackageName:com.cabse.cet.web
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/6/2 17:32
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    @PostMapping("/login")
    public Result<Teacher> loginController(@RequestParam String username, @RequestParam Integer jobnumber, @RequestParam String password){
        Teacher teacher = teacherService.loginService(username, jobnumber, password);
        if (teacher != null && teacher.getState() != -1){
            return Result.success(teacher, "Login success!");
        }else if(teacher != null && teacher.getState() == -1){
            return Result.error("102", "Fail. User is frozen!");
        }else{
            return Result.error("100", "Username or password is wrong!");
        }
    }

//    @PostMapping("/register")
//    public Result<Teacher> registController(@RequestBody Teacher newTeacher){
//        Teacher user = teacherService.registService(newTeacher);
//
//        if(user!=null){
//            return Result.success(user,"Sign up success!");
//        }else{
//            return Result.error("101","Fail. User has existed!");
//        }
//    }
}
