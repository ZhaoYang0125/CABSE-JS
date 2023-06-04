package com.cabse.cet.service;

import com.cabse.cet.entity.Studentprofile;

public interface StudentprofileService {
    Studentprofile saveStudentprofile(Studentprofile studentprofile);
    Studentprofile findStudentprofile(Integer uid);
}
