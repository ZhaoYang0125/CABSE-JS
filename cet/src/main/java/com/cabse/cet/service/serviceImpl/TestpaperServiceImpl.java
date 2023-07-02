package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.dao.TestpaperDao;
import com.cabse.cet.entity.Testpaper;
import com.cabse.cet.service.TestpaperService;
import com.cabse.cet.utils.CurrentDate;
import com.cabse.cet.utils.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;

/**
 * @ClassName: TestpaperServiceImpl
 * @PackageName:com.cabse.cet.service.serviceImpl
 * @Description: TODO
 * @Author cd
 * @Date 2023/6/2 20:00
 * @Version 1.0.0
 */

@Service
public class TestpaperServiceImpl implements TestpaperService {
    @Resource
    private TestpaperDao testpaperDao;

    @Override
    public Testpaper saveService(Testpaper tp) {
        System.out.println(Integer.parseInt(CurrentDate.getTestDate()));
        Testpaper testpaper = testpaperDao.findByPaperid(Integer.parseInt(CurrentDate.getTestDate()));
        if (testpaper != null){
            return null;
        }else {
            tp.setPaperid(Integer.parseInt(CurrentDate.getTestDate()));
            Testpaper newPaper = testpaperDao.save(tp);
            return newPaper;
        }
    }

    @Override
    public Paper testService(Integer paperid) {
        Testpaper testpaper = testpaperDao.findByPaperid(paperid);
        if (testpaper == null){
            return null;
        }

        String url = testpaper.getUrl();
        if (url != null) {
            Paper paper = Paper.get(url);
            return paper;
        }
        return null;
    }

}
