package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.dao.TestpaperDao;
import com.cabse.cet.service.TestpaperService;
import org.springframework.beans.factory.annotation.Autowired;

public class TestpaperServiceImpl implements TestpaperService {
    @Autowired
    private TestpaperDao testpaperDao;


}
