package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.dao.StudentprofileDao;
import com.cabse.cet.entity.Studentprofile;
import com.cabse.cet.service.StudentprofileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cabse.cet.utils.IDGeneration.getGeneratedID;

@Service
public class StudentprofileServiceImpl implements StudentprofileService {
    @Autowired
    private StudentprofileDao studentprofileDao;

    @Override
    public Studentprofile saveStudentprofile(Studentprofile studentprofile){
        Studentprofile retStudentprofile = studentprofileDao.findByUid(studentprofile.getUid());
        Studentprofile newprofile = null;
        if (retStudentprofile == null){
//            studentprofile.setSid(getGeneratedID());
            if (studentprofileDao.findBySid(studentprofile.getSid()) != null){
                return null;
            }
            newprofile = studentprofileDao.save(studentprofile);
        }else{
//            System.out.println("here");
            studentprofileDao.modifyProfile(studentprofile.getUid(),
                                            studentprofile.getSname(),
                                            studentprofile.getGender(),
                                            studentprofile.getAge(),
                                            studentprofile.getSchool());
            newprofile = studentprofileDao.findByUid(studentprofile.getUid());
//            System.out.println("sname" + newprofile.getSname());
        }
        return newprofile;
    }

    @Override
    public Studentprofile findStudentprofile(Integer uid) {
        return studentprofileDao.findByUid(uid);
    }

    @Override
    public Integer sidService(Integer uid) {
        Integer sid = (studentprofileDao.findByUid(uid)).getSid();
        return sid;
    }

    @Override
    public List<Studentprofile> getList(){
        return studentprofileDao.findAll();
    }

    @Override
    public void deleteService(Integer uid){
        studentprofileDao.deleteByUid(uid);
    }

}
