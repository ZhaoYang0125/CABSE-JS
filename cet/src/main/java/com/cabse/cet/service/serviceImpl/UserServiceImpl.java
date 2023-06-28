package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.dao.StudentprofileDao;
import com.cabse.cet.dao.UserDao;
import com.cabse.cet.entity.Studentprofile;
import com.cabse.cet.entity.User;
import com.cabse.cet.service.UserService;
import com.cabse.cet.utils.Security;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.annotation.Resource;

import static com.cabse.cet.utils.IDGeneration.getGeneratedID;

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
    @Resource
    private StudentprofileDao studentprofileDao;

    @Override
    public User loginService(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user != null && Security.matchesPassword(password, user.getPassword())) {
            user.setPassword("");
            return user;
        }else{
            return null;
        }
    }

    @Override
    public User registService(User user) {
        if (userDao.findByUsername(user.getUsername()) != null){
            return null;
        }else{
            user.setState(1);
            String encode = Security.encodePassword(user.getPassword());
            user.setPassword(encode);
            User newUser = userDao.save(user);
            if(newUser != null){
                Studentprofile studentprofile = new Studentprofile();
                studentprofile.setUid(newUser.getUid());
                studentprofile.setExamid(getGeneratedID());
                Studentprofile newStudentprofile = studentprofileDao.save(studentprofile);
                if(newStudentprofile == null){
                    userDao.delete(newUser);
                    return null;
                }
                newUser.setPassword("");
            }

            return newUser;
        }
    }
}
