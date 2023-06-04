package com.cabse.cet.service;

import com.cabse.cet.entity.Studentprofile;

import java.util.List;

public interface StudentprofileService {
    Studentprofile saveStudentprofile(Studentprofile studentprofile);
    Studentprofile findStudentprofile(Integer uid);
    Integer sidService(Integer uid);
    List<Studentprofile> getList();
    void deleteService(Integer uid);
}
