package com.cabse.cet.service;

import com.cabse.cet.entity.Admin;
import com.cabse.cet.entity.Teacher;

/**
 * @ClassName: UserService
 * @PackageName:com.cabse.cet.service.serviceImpl
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/5/21 19:57
 * @Version 1.0.0
 */
public interface AdminService {
    Admin loginService(String username, String password, String token);
//    Admin registService(Admin admin);
}
