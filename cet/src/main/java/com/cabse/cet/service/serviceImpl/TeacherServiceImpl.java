package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.dao.TeacherDao;
import com.cabse.cet.entity.Teacher;
import com.cabse.cet.service.TeacherService;
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
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherDao teacherDao;

    @Override
    public Teacher loginService(String username, Integer jobnumber, String password) {
        Teacher teacher = teacherDao.findByUsernameAndJobnumberAndPassword(username, jobnumber, password);
        if (teacher != null) {
            teacher.setPassword("");
        }
        return teacher;
    }

//    @Override
//    public Teacher registService(Teacher teacher) {
//        if (teacherDao.findByUsername(teacher.getUsername()) != null){
//            return null;
//        }else{
//            teacher.setState(1);
//            Teacher newTeacher = teacherDao.save(teacher);
//            if(newTeacher != null){
//                newTeacher.setPassword("");
//            }
//            return newTeacher;
//        }
//    }
}
