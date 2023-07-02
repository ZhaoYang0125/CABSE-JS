package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.entity.Teacher;
import com.cabse.cet.service.TeacherService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherServiceImplTest {
    @Resource
    private TeacherService teacherService;

    @Test
    void loginService() {
        Teacher t1 = teacherService.loginService("t1", 1000000, "111111a");
        Assertions.assertNotNull(t1);
        Assertions.assertEquals("t1", t1.getUsername());
        Assertions.assertEquals("", t1.getPassword());

        Teacher t2 = teacherService.loginService("t", 1000000, "111111a");
        Assertions.assertNull(t2);

        Teacher t3 = teacherService.loginService("t1", 1000000, "111111");
        Assertions.assertNull(t3);

        Teacher t4 = teacherService.loginService("t1", 000000, "111111a");
        Assertions.assertNull(t4);
    }
}