package com.cabse.cet;

import com.cabse.cet.dao.AdminDao;
import com.cabse.cet.dao.TeacherDao;
import com.cabse.cet.dao.UserDao;
import com.cabse.cet.entity.Admin;
import com.cabse.cet.entity.Teacher;
import com.cabse.cet.entity.User;
import com.cabse.cet.utils.Security;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CetApplicationTests {

    @Resource
    TeacherDao teacherDao;
    @Resource
    AdminDao adminDao;
    @Resource
    UserDao userDao;

    @Test
    void contextLoads() {
        Teacher teacher1 = new Teacher("xiaohong", "111111", 1, 1020000);
        teacherRegistService(teacher1);
        Teacher teacher2 = new Teacher("zhanglian", "222222", 1, 1020330);
        teacherRegistService(teacher2);
        Teacher teacher3 = new Teacher("lanhong", "333333", 1, 10200400);
        teacherRegistService(teacher3);

        Admin admin1 = new Admin("admin1", "111111", 1, "admin-SKdsdafawed");
        adminRegistService(admin1);
        Admin admin2 = new Admin("admin2", "222222", 1, "admin-Lkdasviaew");
        adminRegistService(admin2);
        Admin admin3 = new Admin("admin3", "333333", 1, "admin-asdfbLDDISd");
        adminRegistService(admin3);

        User user1 = new User("xiaohong", "111111", 1);
        userRegistService(user1);
        User user2 = new User("xiaoming", "222222", 1);
        userRegistService(user2);
        User user3 = new User("lanlan", "333333", 1);
        userRegistService(user3);
    }

    public Teacher teacherRegistService(Teacher teacher) {
        if (teacherDao.findByUsername(teacher.getUsername()) != null){
            return null;
        }else{
            teacher.setState(1);
            String encode = Security.encodePassword(teacher.getPassword());
            teacher.setPassword(encode);
            Teacher newTeacher = teacherDao.save(teacher);
            if(newTeacher != null){
                newTeacher.setPassword("");
            }
            return newTeacher;
        }
    }

    public Admin adminRegistService(Admin admin) {
        if (adminDao.findByUsername(admin.getUsername()) != null){
            return null;
        }else{
            admin.setState(1);
            String encode = Security.encodePassword(admin.getPassword());
            admin.setPassword(encode);
            Admin newAdmin = adminDao.save(admin);
            if(newAdmin != null){
                newAdmin.setPassword("");
            }
            return newAdmin;
        }
    }

    public User userRegistService(User user) {
        if (userDao.findByUsername(user.getUsername()) != null){
            return null;
        }else{
            user.setState(1);
            String encode = Security.encodePassword(user.getPassword());
            user.setPassword(encode);
            User newUser = userDao.save(user);
            if(newUser != null){
                newUser.setPassword("");
            }
            return newUser;
        }
    }

}
