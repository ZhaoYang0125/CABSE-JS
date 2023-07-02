package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.entity.Studentprofile;
import com.cabse.cet.service.StudentprofileService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentprofileServiceImplTest {
    @Resource
    StudentprofileService studentprofileService;

    @Test
    void saveStudentprofile() {
        Studentprofile studentprofile1 = new Studentprofile();
        studentprofile1.setUid(100003);
        studentprofile1.setAge(22);
        Studentprofile newProfile1 = studentprofileService.saveStudentprofile(studentprofile1);
        Assertions.assertNotNull(newProfile1);
        Assertions.assertEquals(20232139, newProfile1.getExamid());
        Assertions.assertEquals(22, newProfile1.getAge());

        Studentprofile studentprofile2 = new Studentprofile();
        studentprofile2.setUid(100001);
        studentprofile2.setExamid(20231704);
        Studentprofile newProfile2 = studentprofileService.saveStudentprofile(studentprofile2);
        Assertions.assertNull(newProfile2);

        Studentprofile studentprofile3 = new Studentprofile();
        studentprofile3.setExamid(20231705);
        Studentprofile newProfile3 = studentprofileService.saveStudentprofile(studentprofile3);
        Assertions.assertNotNull(newProfile3);
        Assertions.assertEquals(20231705, newProfile3.getExamid());
    }

    @Test
    void modifyStudentprofile() {
        Studentprofile studentprofile = new Studentprofile();
        studentprofile.setUid(100003);
        studentprofile.setExamid(20232139);
        studentprofile.setAge(21);
        Studentprofile newProfile = studentprofileService.modifyStudentprofile(studentprofile);
        Assertions.assertNotNull(newProfile);
        Assertions.assertEquals(20232139, newProfile.getExamid());
        Assertions.assertEquals(21, newProfile.getAge());
    }

    @Test
    void examidService() {
        Integer examid1 = studentprofileService.examidService(100004);
        Assertions.assertEquals(20231704, examid1);

        Integer examid2 = studentprofileService.examidService(100001);
        Assertions.assertNull(examid2);
    }

}