package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.entity.Studentprofile;
import com.cabse.cet.service.EnrollService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EnrollServiceImplTest {

    @Resource
    private EnrollService enrollService;

    @Test
    void findStudentProfile() {
        Studentprofile studentprofile1 = enrollService.findStudentProfile(100003);
        Assertions.assertNotNull(studentprofile1);
        Assertions.assertEquals(20232139, studentprofile1.getExamid());

        Studentprofile studentprofile2 = enrollService.findStudentProfile(100001);
        Assertions.assertNull(studentprofile2);
    }
}