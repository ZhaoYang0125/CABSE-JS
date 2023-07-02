package com.cabse.cet.service.serviceImpl;

/*
 * Created with IntelliJ IDEA.
 * ClassName: ReportServiceImpl
 * User: 张朝阳
 * Date: 2023/6/4
 * Time: 9:07
 * Description:学生成绩报告服务层函数实现
 */
import com.cabse.cet.dao.ReportDao;
import com.cabse.cet.entity.Report;
import com.cabse.cet.service.ReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReportServiceImpl implements ReportService {
    @Resource
    private ReportDao reportDao;

    //更新翻译题的分数
    @Override
    public boolean updateTranslationService(Integer paperid, Integer examid, Float score) {
        if(reportDao.updateTranslation(paperid,examid,score)!=0)
            return true;
        else
            return false;
    }

    //更新作文分数
    @Override
    public boolean updateWritingService(Integer paperid, Integer examid, Float score) {
        if(reportDao.updateWriting(paperid, examid, score)!=0)
            return true;
        else
            return false;
    }

    @Override
    public boolean saveService(Report report) {
        Report r = reportDao.findByPaperidAndExamid(report.getPaperid(),report.getExamid());
        if (r != null){
            reportDao.updateReport(report.getPaperid(), report.getExamid(),
                                    report.getComprehension(),
                                    report.getListening(),
                                    report.getTime(),
                                    report.getTranslation(),
                                    report.getWriting());
            return true;
        }else{
            if(reportDao.save(report.getExamid(), report.getPaperid(), report.getListening(), report.getComprehension(), report.getTime())!=0)
                return true;
            else
                return false;
        }
    }

    @Override
    public Report searchService(Integer paperid, Integer examid) {
        Report report = reportDao.findByPaperidAndExamid(paperid, examid);
        if (report != null) {
            return report;
        }
        return null;
    }
}
