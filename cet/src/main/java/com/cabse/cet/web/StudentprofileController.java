package com.cabse.cet.web;

import com.cabse.cet.dao.StudentprofileDao;
import com.cabse.cet.entity.Studentprofile;
import com.cabse.cet.service.StudentprofileService;
import com.cabse.cet.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/modifyprofile")
    public Result<Studentprofile> modifyProfileController(@RequestBody Studentprofile studentprofile){
        Studentprofile newStudentProfile = studentprofileService.modifyStudentprofile(studentprofile);

        if (newStudentProfile != null){
            return Result.success(newStudentProfile, "student profile submit successfully!");
        }else{
            return Result.error("103", "Fail. illegal profile!");
        }
    }

    @PostMapping("/findprofile")
    public Result<Studentprofile> findProfileController(@RequestParam Integer uid){
        Studentprofile resStudentprofile = studentprofileService.findStudentprofile(uid);
        if (resStudentprofile != null){
            return Result.success(resStudentprofile);
        }else{
            return Result.error("401", "Fail. profile not found!");
        }
    }

    @GetMapping("/getDataList")
    public Result<List<Studentprofile>> getDataList() {
        List<Studentprofile> list = studentprofileService.getList() ;
        return  Result.success(list);
    }

    @PostMapping("/delete")
    public Result<Studentprofile> delete(@RequestParam Integer uid){
        studentprofileService.deleteService(uid);
        return Result.success();
    }
}
