package com.cabse.cet.web;
/*
 * Created with IntelliJ IDEA.
 * ClassName: ReportController
 * User: 张朝阳
 * Date: 2023/6/3
 * Time: 13:05
 * Description:学生成绩报告控制类
 */

import com.cabse.cet.service.ReportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("teacher2")
public class ReportController {
    @Resource ReportService reportService;

    @PostMapping("writing")
    public boolean updateTranslationController(@RequestParam Integer paperid, @RequestParam Integer examid,
                                               @RequestParam Float score){
        return reportService.updateTranslationService(paperid, examid, score);
    }

    @PostMapping("translation")
    public boolean updateWritingController(@RequestParam Integer paperid, @RequestParam Integer examid,
                                           @RequestParam Float score){
        return reportService.updateWritingService(paperid, examid, score);
    }
}
