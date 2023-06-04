package com.cabse.cet.web;

import com.cabse.cet.dao.StudentprofileDao;
import com.cabse.cet.dao.UserDao;
import com.cabse.cet.entity.Studentprofile;
import com.cabse.cet.service.EnrollService;
import com.cabse.cet.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @ClassName: EnrollController
 * @PackageName:com.cabse.cet.web
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/6/3 11:01
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/enroll")
public class EnrollController {
    @Resource
    private EnrollService enrollService;
    @Resource
    private UserDao userDao;

    @PostMapping("/confirm")
    public Result<Studentprofile> confirmEnrollController(@RequestParam Integer uid){
        Studentprofile studentprofile = enrollService.findStudentProfile(uid);
        if (studentprofile != null){
            userDao.modifyState(uid, 2); // state = 2 已报名
            return Result.success(studentprofile, "Enroll successfully!");
        }else{
            return Result.error("104", "Fail. Complete your profile first.");
        }
    }
}
