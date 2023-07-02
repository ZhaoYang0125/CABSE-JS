package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.entity.Testpaper;
import com.cabse.cet.service.TestpaperService;
import com.cabse.cet.utils.Paper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestpaperServiceImplTest {
    @Resource
    private TestpaperService testpaperService;

    @Test
    void saveService() {
        Testpaper testpaper = new Testpaper();
        Testpaper newPaper = testpaperService.saveService(testpaper);
        Assertions.assertNull(newPaper);
    }

    @Test
    void testService() {
        Paper paper1 = testpaperService.testService(202312);
        Assertions.assertNull(paper1);

        Paper paper2 = testpaperService.testService(202306);
        Assertions.assertNotNull(paper2);
    }
}