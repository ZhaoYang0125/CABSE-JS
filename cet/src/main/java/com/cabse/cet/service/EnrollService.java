package com.cabse.cet.service;

import com.cabse.cet.entity.Studentprofile;
import org.springframework.stereotype.Service;

/**
 * @ClassName: EnrollService
 * @PackageName:com.cabse.cet.service
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/6/3 11:03
 * @Version 1.0.0
 */

public interface EnrollService {
    Studentprofile findStudentProfile(Integer uid);
}
