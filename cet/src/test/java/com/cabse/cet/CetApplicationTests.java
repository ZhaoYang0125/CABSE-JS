package com.cabse.cet;

import com.cabse.cet.dao.AdminDao;
import com.cabse.cet.dao.StudentprofileDao;
import com.cabse.cet.dao.TeacherDao;
import com.cabse.cet.dao.UserDao;
import com.cabse.cet.entity.Admin;
import com.cabse.cet.entity.Studentprofile;
import com.cabse.cet.entity.Teacher;
import com.cabse.cet.entity.User;
import com.cabse.cet.utils.Security;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static com.cabse.cet.utils.IDGeneration.getGeneratedID;

@SpringBootTest
class CetApplicationTests {

    @Resource
    TeacherDao teacherDao;
    @Resource
    AdminDao adminDao;
    @Resource
    UserDao userDao;
    @Resource
    StudentprofileDao studentprofileDao;

    @Test
    void contextLoads() {
        Teacher teacher1 = new Teacher("t1", "111111a", 1, 1000000);
        teacherRegistService(teacher1);
        Teacher teacher2 = new Teacher("t2", "222222abc", 1, 1020330);
        teacherRegistService(teacher2);
        Teacher teacher3 = new Teacher("t3", "333333abc", 1, 10200400);
        teacherRegistService(teacher3);
        Admin admin1 = new Admin("admin", "111111a", 1, "1a");
        adminRegistService(admin1);
        Admin admin2 = new Admin("admin2", "222222abc", 1, "admin-Lkdasviaew");
        adminRegistService(admin2);
        Admin admin3 = new Admin("admin3", "333333abc", 1, "admin-asdfbLDDISd");
        adminRegistService(admin3);

        User user1 = new User("lan", "111111a", 1);
        userRegistService(user1);
        User user2 = new User("ming", "222222abc", 1);
        userRegistService(user2);
        User user3 = new User("hei", "333333abc", 1);
        userRegistService(user3);
        User user4 = new User("hong", "444444abc", 1);
        userRegistService(user4);
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

//    public User userRegistService(User user) {
//        if (userDao.findByUsername(user.getUsername()) != null){
//            return null;
//        }else{
//            user.setState(1);
//            String encode = Security.encodePassword(user.getPassword());
//            user.setPassword(encode);
//            User newUser = userDao.save(user);
//            if(newUser != null){
//                newUser.setPassword("");
//            }
//            return newUser;
//        }
//    }

    public User userRegistService(User user) {
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
