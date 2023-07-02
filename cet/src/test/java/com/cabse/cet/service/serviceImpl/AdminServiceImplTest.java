package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.entity.Admin;
import com.cabse.cet.service.AdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceImplTest {

    @Resource
    private AdminService adminService;

    @Test
    void loginService() {
        Admin admin1 = adminService.loginService("admin", "111111a", "1a");
        Assertions.assertNotNull(admin1);
        Assertions.assertEquals("admin", admin1.getUsername());
        Assertions.assertEquals("", admin1.getPassword());

        Admin admin2 = adminService.loginService("admin1", "111111a", "1a");
        Assertions.assertNull(admin2);

        Admin admin3 = adminService.loginService("admin", "111111", "1a");
        Assertions.assertNull(admin3);

        Admin admin4 = adminService.loginService("admin", "111111a", "1");
        Assertions.assertNull(admin4);
    }
}