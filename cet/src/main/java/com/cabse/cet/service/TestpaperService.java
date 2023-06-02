package com.cabse.cet.service;

import com.cabse.cet.utils.Paper;
import com.cabse.cet.utils.PaperInfo;

public interface TestpaperService {
    PaperInfo testService(Integer paperid);
    Integer countService();
}
