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
    public boolean updateTranslationService(Integer paperid, Integer sid, Float score) {
        if(reportDao.updateTranslation(paperid,sid,score)!=0)
            return true;
        else
            return false;
    }

    //更新作文分数
    @Override
    public boolean updateWritingService(Integer paperid, Integer sid, Float score) {
        if(reportDao.updateWriting(paperid, sid, score)!=0)
            return true;
        else
            return false;
    }

    @Override
    public boolean saveService(Report report) {
        if(reportDao.save(report.getSid(), report.getPaperid(), report.getListening(), report.getComprehension(), report.getTime())!=0)
            return true;
        else
            return false;
    }

    @Override
    public Report searchService(Integer paperid, Integer sid) {
        Report report = reportDao.findByPaperidAndSid(paperid, sid);
        if (report != null) {
            return report;
        }
        return null;
    }
}
