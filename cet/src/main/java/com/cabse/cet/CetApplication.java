package com.cabse.cet;

/**
 * @ClassName: CetApplication
 * @PackageName:com.cabse.cet
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/5/21 15:41
 * @Version 1.0.0
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.cabse.cet.web", "com.cabse.cet.service"})
public class CetApplication {

    public static void main(String[] args) {
        SpringApplication.run(CetApplication.class, args);
    }

}