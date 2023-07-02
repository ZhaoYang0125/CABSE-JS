package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.entity.Studentanswer;
import com.cabse.cet.service.StudentanswerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentanswerServiceImplTest {
    @Resource
    StudentanswerService studentanswerService;

    @Test
    void saveService() {
        Studentanswer newAnswer = new Studentanswer();
        Studentanswer resAnswer = studentanswerService.saveService(newAnswer);
        Assertions.assertNotNull(resAnswer);
    }

    @Test
    void searchAnswerService() {
        Studentanswer studentanswer1 = studentanswerService.searchAnswerService(202306, 20232139);
        Assertions.assertNotNull(studentanswer1);
        Assertions.assertEquals("./tmp/stu_ans_20232139.ser", studentanswer1.getUrl());

        Studentanswer studentanswer2 = studentanswerService.searchAnswerService(202306, 2023);
        Assertions.assertNull(studentanswer2);
    }

    @Test
    void getAnswerList() {
        List<Studentanswer> studentanswerList1 = studentanswerService.getAnswerList(202306);
        Assertions.assertEquals(1, studentanswerList1.size());
        Assertions.assertEquals("./tmp/stu_ans_20232139.ser", studentanswerList1.get(0).getUrl());

        List<Studentanswer> studentanswerList2 = studentanswerService.getAnswerList(202307);
        Assertions.assertEquals(0, studentanswerList2.size());
    }
}