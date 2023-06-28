package com.cabse.cet.dao;

import com.cabse.cet.entity.Studentprofile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentprofileDao extends JpaRepository<Studentprofile, Integer> {
    Studentprofile findByUid(Integer uid);
    Studentprofile findByExamid(Integer examid);

    @Transactional
    void deleteByUid(Integer uid);

    @Transactional
    void deleteByExamid(Integer examid);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Studentprofile s set s.sname = ?2 , s.gender = ?3, s.age = ?4, s.school = ?5, s.majerity = ?6, s.enrollmentyear = ?7, s.degree = ?8, s.examid = ?9 where s.uid = ?1")    //  ?2: 表示第二个参数, ?1: 表示第一个参数
    public void modifyProfile(Integer uid, String sname, String gender, Integer age, String school, String majerity, String enrollmentyear, String degree, Integer Examid);

}
