package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.dao.UserDao;
import com.cabse.cet.entity.User;
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
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User loginService(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, password);
        if (user != null) {
            user.setPassword("");
        }
        return user;
    }

    @Override
    public User registService(User user) {
        if (userDao.findByUsername(user.getUsername()) != null){
            return null;
        }else{
            user.setState(1);
            User newUser = userDao.save(user);
            if(newUser != null){
                newUser.setPassword("");
            }
            return newUser;
        }
    }
}
