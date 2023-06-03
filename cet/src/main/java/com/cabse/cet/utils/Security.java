package com.cabse.cet.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName: Security
 * @PackageName:com.cabse.cet.utils
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/6/3 17:49
 * @Version 1.0.0
 */
public class Security {

    public static String encodePassword(String pwd)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(pwd);
    }

    public static boolean matchesPassword(String realpwd, String encodedpwd)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(realpwd, encodedpwd);
    }
}
