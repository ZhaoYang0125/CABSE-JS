package com.cabse.cet;

/**
 * @ClassName: CetApplication
 * @PackageName:com.cabse.cet
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/5/21 15:41
 * @Version 1.0.0
 */

import com.cabse.cet.utils.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication(scanBasePackages={"com.cabse.cet.web", "com.cabse.cet.service"})
public class CetApplication {

    public static void main(String[] args) {

        SpringApplication.run(CetApplication.class, args);
        Paper.testSer();
        Paper.testDeser();
    }

}