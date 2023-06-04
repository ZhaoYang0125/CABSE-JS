package com.cabse.cet.web;

import com.cabse.cet.entity.Report;
import com.cabse.cet.entity.Studentanswer;
import com.cabse.cet.entity.Testpaper;
import com.cabse.cet.service.*;
import com.cabse.cet.utils.Answer;
import com.cabse.cet.utils.Paper;

import com.cabse.cet.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestpaperService testpaperService;

    @Resource
    private StudentprofileService studentprofileService;

    @Resource
    private PaperanswerService paperanswerService;

    @Autowired
    private StudentanswerService studentanswerService;

    @Autowired
    private ReportService reportService;

    private static Integer paperid;

    @PostMapping("/paper")
    public Result<Paper> paperController() {
        Integer count = testpaperService.countService();
        Random rand = new Random();
        Integer row = rand.nextInt(count);
        System.out.println(row.toString());
        Paper paper = testpaperService.testService(row);
        paperid = testpaperService.paperidService(row);
        System.out.println(paperid);
        System.out.println(paper.toString());
        return Result.success(paper, "Success load paper!");
    }

    @PostMapping("/submit")
    public Result<Answer> submitController(@RequestParam("writing") String writing,
                                           @RequestParam("listeningChoices") String[] listeningChoices,
                                           @RequestParam("choicesOfSectionA") String[] choicesOfSectionA,
                                           @RequestParam("choicesOfSectionB") String[] choicesOfSectionB,
                                           @RequestParam("choicesOfSectionC") String[] choicesOfSectionC,
                                           @RequestParam("translation") String translation,
                                           @RequestParam("uid") Integer uid
    ){
        LocalDateTime submitTime = LocalDateTime.now();
        int len = listeningChoices.length;
        char[] listenning = new char[len];
        for (int i=0; i<len; i++) {
            listenning[i] = listeningChoices[i].charAt(0);
        }
        int len1 = choicesOfSectionA.length;
        int len2 = choicesOfSectionB.length;
        int len3 = choicesOfSectionC.length;
        System.out.println(len1+len2+len3);
        char[] reading = new char[len1+len2+len3];
        for (int i=0; i<len1; i++) {
            reading[i] = choicesOfSectionA[i].charAt(0);
        }
        for (int i=len1; i<len1+len2; i++) {
            reading[i] = choicesOfSectionB[i-len1].charAt(0);
        }
        for (int i=len1+len2; i<len1+len2+len3; i++) {
            reading[i] = choicesOfSectionC[i-len1-len2].charAt(0);
        }
        Answer a = new Answer(writing, listenning, reading, translation);
        Answer.save(a, "stu_ans.ser");
        String url = "./tmp/stu_ans.ser";
        Studentanswer sa = new Studentanswer();
        sa.setUrl(url);
        sa.setTime(submitTime);
        System.out.println(paperid);
        sa.setPaperid(paperid);
        System.out.println(studentprofileService.sidService(uid));
        Integer sid = studentprofileService.sidService(uid);
        sa.setSid(sid);
        Studentanswer newAnswer = studentanswerService.saveService(sa);
        String paperAnswerUrl = paperanswerService.searchAnswerService(paperid).getUrl();
        Answer paperAnswer = Answer.get(paperAnswerUrl);

        //听力阅卷
        float grade1 = 0.0f;
        for (int i=0; i<25; i++)
        {
            if (a.getListenning()[i] == paperAnswer.getListenning()[i]) {
                if (i < 15) {
                    grade1 += 7.1;
                }
                else {
                    grade1 += 14.2;
                }
            }
        }
        Float listenningGrade = new Float(grade1);
        System.out.println(listenningGrade);

        //阅读阅卷
        float grade2 = 0.0f;
        for (int i=0; i<30; i++) {
            if (a.getReading()[i] == paperAnswer.getReading()[i]) {
                if (i < 10) {
                    grade2 += 3.55;
                }
                else if (i < 20){
                    grade2 += 7.1;
                }
                else {
                    grade2 += 14.2;
                }
            }
        }
        Float readingGrade = new Float(grade2);
        System.out.println(readingGrade);

        Report report = new Report();
        report.setListening(grade1);
        report.setComprehension(grade2);
        report.setSid(sid);
        report.setPaperid(paperid);
        report.setTime(submitTime);
        reportService.saveService(report);
        if(newAnswer!=null){
            System.out.println(newAnswer);
            return Result.success(a, "Success submit paper!");
        }
        else {
            return Result.error("666", "Fail. submit paper failed");
        }
    }
}