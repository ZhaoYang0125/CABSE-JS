package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.dao.StudentprofileDao;
import com.cabse.cet.entity.Studentprofile;
import com.cabse.cet.service.StudentprofileService;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentprofileServiceImpl implements StudentprofileService {
    @Autowired private StudentprofileDao studentprofileDao;

    @Override
    public Studentprofile saveStudentprofile(Studentprofile studentprofile){
        Studentprofile retStudentprofile = studentprofileDao.findByUid(studentprofile.getUid());
        Studentprofile newprofile = null;
        if (retStudentprofile == null){
            newprofile = studentprofileDao.save(studentprofile);
        }else{
            studentprofileDao.modifyProfile(studentprofile.getUid(),
                                            studentprofile.getSname(),
                                            studentprofile.getGender(),
                                            studentprofile.getAge(),
                                            studentprofile.getSchool());
            newprofile = studentprofileDao.findByUid(studentprofile.getUid());
        }
        return newprofile;
    }


}
