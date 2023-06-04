package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.dao.TestpaperDao;
import com.cabse.cet.entity.Testpaper;
import com.cabse.cet.service.TestpaperService;
import com.cabse.cet.utils.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
        Testpaper newPaper = testpaperDao.save(tp);
        return newPaper;
    }

    @Override
    public Paper testService(Integer row) {
        String url = testpaperDao.findByRow(row);
        System.out.println(url);
        if (url != null) {
            Paper paper = Paper.get(url);
            return paper;
        }
        return null;
    }

    @Override
    public Integer paperidService(Integer row) {
        Integer paperid = testpaperDao.paperidFindByRow(row);
        System.out.println(paperid);
        if (paperid != null) {
            return paperid;
        }
        return null;
    }

    @Override
    public Integer countService() {
        return testpaperDao.paperCount();
    }

}
