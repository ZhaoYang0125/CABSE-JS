package com.cabse.cet.dao;

import com.cabse.cet.entity.Studentprofile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentprofileDao extends JpaRepository<Studentprofile, Integer> {
    Studentprofile findByUid(Integer uid);

    @Query("update Studentprofile s set s.sname = ?2 , s.gender = ?3, s.age = ?4, s.school = ?5 where s.uid = ?1")    //  ?2: 表示第二个参数, ?1: 表示第一个参数
    public void modifyProfile(Integer uid, String sname, Studentprofile.Sex gender, Integer age, String school);
}
