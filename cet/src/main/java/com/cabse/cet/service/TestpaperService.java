package com.cabse.cet.service;

import com.cabse.cet.entity.Testpaper;
import com.cabse.cet.utils.Paper;

public interface TestpaperService {
    Testpaper saveService(Testpaper tp);
    Paper testService(Integer row);
    Integer paperidService(Integer row);
    Integer countService();
}
