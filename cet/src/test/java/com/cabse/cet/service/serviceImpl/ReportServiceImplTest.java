package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.entity.Report;
import com.cabse.cet.service.ReportService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReportServiceImplTest {

    @Resource
    ReportService reportService;

    @Test
    void updateTranslationService() {
        boolean result1 = reportService.updateTranslationService(202306,20232139,20.5f);
        Assertions.assertTrue(result1);

        boolean result2 = reportService.updateTranslationService(202306,2013458,20.5f);
        Assertions.assertFalse(result2);
    }

    @Test
    void saveService() {
        Report newReport = new Report();
        boolean result = reportService.saveService(newReport);
        Assertions.assertTrue(result);
    }

    @Test
    void searchService() {
        Report report1 = reportService.searchService(202306, 20232139);
        Assertions.assertNotNull(report1);
        Assertions.assertEquals(20.5f, report1.getTranslation());

        Report report2 = reportService.searchService(202306, 2023);
        Assertions.assertNull(report2);
    }
}