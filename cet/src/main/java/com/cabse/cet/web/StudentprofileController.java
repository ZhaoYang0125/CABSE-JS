package com.cabse.cet.web;

import com.cabse.cet.entity.Studentprofile;
import com.cabse.cet.service.StudentprofileService;
import com.cabse.cet.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: StudentprofileController
 * @PackageName:com.cabse.cet.web
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/6/1 20:55
 * @Version 1.0.0
 */

@RestController
@RequestMapping("/studentprofile")
public class StudentprofileController {

    @Resource
    private StudentprofileService studentprofileService;

    @PostMapping("/profile")
    public Result<Studentprofile> profileController(@RequestBody Studentprofile studentprofile){
        Studentprofile newStudentProfile = studentprofileService.saveStudentprofile(studentprofile);

        if (newStudentProfile != null){
            return Result.success(newStudentProfile, "student profile submit successfully!");
        }else{
         return Result.error("103", "Fail. illegal profile!");
        }
    }
}
