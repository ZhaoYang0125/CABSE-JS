package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.dao.AdminDao;
import com.cabse.cet.dao.UserDao;
import com.cabse.cet.entity.Admin;
import com.cabse.cet.entity.User;
import com.cabse.cet.service.AdminService;
import com.cabse.cet.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: UserServiceImpl
 * @PackageName:com.cabse.cet.service.serviceImpl
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/5/21 20:00
 * @Version 1.0.0
 */

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    @Override
    public Admin loginService(String username, String password) {
        Admin admin = adminDao.findByUsernameAndPassword(username, password);
        if (admin != null) {
            admin.setPassword("");
        }
        return admin;
    }

    @Override
    public Admin registService(Admin admin) {
        if (adminDao.findByUsername(admin.getUsername()) != null){
            return null;
        }else{
            admin.setState(1);
            Admin newAdmin = adminDao.save(admin);
            if(newAdmin != null){
                newAdmin.setPassword("");
            }
            return newAdmin;
        }
    }
}
