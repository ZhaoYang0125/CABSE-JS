package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.dao.ReportDao;
import com.cabse.cet.entity.Report;
import com.cabse.cet.service.ReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReportServiceImpl implements ReportService {
    @Resource
    private ReportDao reportDao;

    @Override
    public boolean updateTranslationService(Integer paperid, Integer sid, Integer score) {
        if(reportDao.updateTranslation(paperid,sid,score)!=0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateWritingService(Integer paperid, Integer sid, Integer score) {
        if(reportDao.updateWriting(paperid, sid, score)!=0)
            return true;
        else
            return false;
    }
}
