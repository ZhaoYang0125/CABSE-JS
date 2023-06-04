package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.dao.StudentprofileDao;
import com.cabse.cet.entity.Studentprofile;
import com.cabse.cet.service.StudentprofileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            studentprofile.setSid(getGeneratedID());
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

    @Override
    public Studentprofile findStudentprofile(Integer uid) {
        return studentprofileDao.findByUid(uid);
    }


}
