package com.cabse.cet.web;

import com.cabse.cet.entity.Report;
import com.cabse.cet.service.ReportService;
import com.cabse.cet.service.StudentprofileService;
import com.cabse.cet.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/grade")
public class GradeController {
    @Resource
    private StudentprofileService studentprofileService;

    @Resource
    private ReportService reportService;

    @PostMapping("/search")
    public Result<Report> searchController(@RequestParam("paperid") Integer paperid,
                                           @RequestParam("uid") Integer uid
    ) {
        Integer sid = studentprofileService.sidService(uid);
        Report report = reportService.searchService(paperid, sid);
//        System.out.println(report.getListening());
//        System.out.println(report.getTranslation());
        if (report != null && report.getTranslation() != null && report.getWriting() != null) {
            return Result.success(report, "Success get grade!");
        }
        else {
            return Result.error("424", "Wait to grade...");
        }
    }
}
