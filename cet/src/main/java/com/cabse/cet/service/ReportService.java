package com.cabse.cet.service;
/*
 * Created with IntelliJ IDEA.
 * ClassName: ReportService
 * User: 张朝阳
 * Date: 2023/6/3
 * Time: 13:05
 * Description:学生成绩报告服务层
 */

import com.cabse.cet.entity.Report;

public interface ReportService {
    boolean updateTranslationService(Integer paperid,Integer examid,Float score);
    boolean updateWritingService(Integer paperid,Integer examid,Float score);
    boolean saveService(Report report);
    Report searchService(Integer paperid, Integer examid);
}
