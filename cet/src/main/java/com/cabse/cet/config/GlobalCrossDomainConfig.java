package com.cabse.cet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: GlobalCrossDomainConfig
 * @PackageName:com.cabse.cet.config
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/5/21 20:39
 * @Version 1.0.0
 */

@Configuration
public class GlobalCrossDomainConfig {
    @Bean
    public WebMvcConfigurer crossConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOriginPatterns("*")
                        .allowCredentials(true)
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*")
                        .exposedHeaders("*");
            }
        };
    }
}
