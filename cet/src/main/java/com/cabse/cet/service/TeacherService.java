package com.cabse.cet.service;

import com.cabse.cet.entity.Teacher;
import com.cabse.cet.entity.User;

/**
 * @ClassName: UserService
 * @PackageName:com.cabse.cet.service.serviceImpl
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/5/21 19:57
 * @Version 1.0.0
 */
public interface TeacherService {
    Teacher loginService(String username, String password);
    Teacher registService(Teacher teacher);
}
