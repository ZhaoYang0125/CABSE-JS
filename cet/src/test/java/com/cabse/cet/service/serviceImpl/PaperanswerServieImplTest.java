package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.entity.Paperanswer;
import com.cabse.cet.service.PaperanswerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaperanswerServieImplTest {
    @Resource
    PaperanswerService paperanswerService;

    @Test
    void searchAnswerService() {
        Paperanswer paperanswer1 = paperanswerService.searchAnswerService(202306);
        Assertions.assertNotNull(paperanswer1);
        Assertions.assertEquals("./tmp/paperAns_202306.ser", paperanswer1.getUrl());

        Paperanswer paperanswer2 = paperanswerService.searchAnswerService(202406);
        Assertions.assertNull(paperanswer2);
    }

    @Test
    void saveAnswerService() {
        Paperanswer newPaperans = new Paperanswer();
        Paperanswer paperanswer = paperanswerService.saveAnswerService(newPaperans);
        Assertions.assertNull(paperanswer);
    }
}