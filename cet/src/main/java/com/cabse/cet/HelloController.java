package com.cabse.cet;

/**
 * @ClassName: HelloController
 * @PackageName:com.cabse.cet
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/5/21 10:41
 * @Version 1.0.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
