package com.cabse.cet.service;
/*
 * Created with IntelliJ IDEA.
 * ClassName: ReportController
 * User: 张朝阳
 * Date: 2023/6/3
 * Time: 13:34
 * Description:学生答案服务层
 */

import com.cabse.cet.entity.Studentanswer;

import java.util.List;

public interface StudentanswerService {
    Studentanswer saveService(Studentanswer sa);
    Studentanswer searchAnswerService(Integer paperid,Integer examid);
    List<Studentanswer> getAnswerList(Integer paperid);
}
