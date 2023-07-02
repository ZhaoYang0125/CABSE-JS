package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.entity.User;
import com.cabse.cet.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    void loginService() {
        User user1 = userService.loginService("lan", "111111a");
        Assertions.assertNotNull(user1);
        Assertions.assertEquals("lan", user1.getUsername());
        Assertions.assertEquals("", user1.getPassword());

        User user2 = userService.loginService("la", "111111a");
        Assertions.assertNull(user2);

        User admin3 = userService.loginService("lan", "111111");
        Assertions.assertNull(admin3);
    }

    @Test
    void registService() {
        User user = new User();
        user.setUsername("lan");
        User newUser = userService.registService(user);
        Assertions.assertNull(newUser);

        User user1 = new User();
        user1.setUsername("liu");
        user1.setPassword("abaaba");
        User newUser1 = userService.registService(user1);
        Assertions.assertNotNull(newUser1);
        Assertions.assertEquals("liu", newUser1.getUsername());
        Assertions.assertEquals("", newUser1.getPassword());
    }
}