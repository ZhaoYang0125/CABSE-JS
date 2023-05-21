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
    public User loginService(String userName, String passWord) {
        User user = userDao.findByUserNameAndPassWord(userName, passWord);
        if (user != null) {
            user.setPassWord("");
        }
        return user;
    }

    @Override
    public User registService(User user) {
        if (userDao.findByUserName(user.getUserName()) != null){
            return null;
        }else{
            User newUser = userDao.save(user);
            if(newUser != null){
                newUser.setPassWord("");
            }
            return newUser;
        }
    }
}
