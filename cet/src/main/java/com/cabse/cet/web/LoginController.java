package com.cabse.cet.web;

/**
 * @ClassName: HelloController
 * @PackageName:com.cabse.cet.web
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/5/21 10:41
 * @Version 1.0.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class LoginController {
    @RequestMapping("/")
    public String login() {
        return "login";
    }
}
