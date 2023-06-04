package com.cabse.cet.web;
/*
 * Created with IntelliJ IDEA.
 * ClassName: StudentanswerController
 * User: 张朝阳
 * Date: 2023/6/2
 * Time: 21:07
 * Description:学生答案控制层
 */

import com.cabse.cet.entity.Studentanswer;
import com.cabse.cet.service.StudentanswerService;
import com.cabse.cet.utils.Answer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("teacher")
public class StudentanswerController {
    @Resource StudentanswerService studentanswerService;

    //根据paperid和sid查找学生作答情况
    @PostMapping("grading")
    public Answer searchAnswerController(@RequestParam Integer paperid, @RequestParam Integer sid) throws IOException, ClassNotFoundException {
        Studentanswer studentanswer=studentanswerService.searchAnswerService(paperid,sid);
        if(studentanswer==null){
            return null;
        }
//        System.out.println(studentanswer);
        System.out.println(studentanswer.getUrl());
        Answer answer=Answer.get(studentanswer.getUrl());
//        System.out.println(answer);
        return answer;
    }
}
