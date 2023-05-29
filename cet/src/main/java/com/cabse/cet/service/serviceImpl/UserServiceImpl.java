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
<<<<<<< HEAD
    public User loginService(String userName, String passWord) {
        User user = userDao.findByUserNameAndPassWord(userName, passWord);
        if (user != null) {
            user.setPassWord("");
=======
    public User loginService(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, password);
        if (user != null) {
            user.setPassword("");
>>>>>>> 12b034c2812629d7e01993e4b12de100c48a99fd
        }
        return user;
    }

    @Override
    public User registService(User user) {
<<<<<<< HEAD
        if (userDao.findByUserName(user.getUserName()) != null){
=======
        if (userDao.findByUsername(user.getUsername()) != null){
>>>>>>> 12b034c2812629d7e01993e4b12de100c48a99fd
            return null;
        }else{
            user.setState(1);
            User newUser = userDao.save(user);
            if(newUser != null){
<<<<<<< HEAD
                newUser.setPassWord("");
=======
                newUser.setPassword("");
>>>>>>> 12b034c2812629d7e01993e4b12de100c48a99fd
            }
            return newUser;
        }
    }
}
