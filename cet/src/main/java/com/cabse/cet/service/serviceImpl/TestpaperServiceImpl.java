package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.dao.TestpaperDao;
import com.cabse.cet.entity.Testpaper;
import com.cabse.cet.service.TestpaperService;
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

}
