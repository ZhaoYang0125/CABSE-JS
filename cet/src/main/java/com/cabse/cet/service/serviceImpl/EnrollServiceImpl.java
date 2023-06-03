package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.dao.StudentprofileDao;
import com.cabse.cet.entity.Studentprofile;
import com.cabse.cet.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: EnrollServiceImpl
 * @PackageName:com.cabse.cet.service.serviceImpl
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/6/3 11:06
 * @Version 1.0.0
 */
@Service
public class EnrollServiceImpl implements EnrollService {

    @Autowired
    private StudentprofileDao studentprofileDao;

    @Override
    public Studentprofile findStudentProfile(Integer uid) {
        Studentprofile resProfile = studentprofileDao.findByUid(uid);
        if (resProfile != null){
            return resProfile;
        }else{
            return null;
        }
    }
}
