package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.dao.TestpaperDao;
import com.cabse.cet.entity.Testpaper;
import com.cabse.cet.service.TestpaperService;
import com.cabse.cet.utils.Paper;
import com.cabse.cet.utils.PaperInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class TestpaperServiceImpl implements TestpaperService {
    @Resource
    private TestpaperDao testpaperDao;

    @Override
    public PaperInfo testService(Integer row) {
        String url = testpaperDao.findByRow(row);
        if (url != null) {
            Paper paper = Paper.get(url);
            PaperInfo info = new PaperInfo();
            info.getInfoFromPaper(paper);
            return info;
        }
        return null;
    }

    @Override
    public Integer countService() {
        return testpaperDao.paperCount();
    }

}
