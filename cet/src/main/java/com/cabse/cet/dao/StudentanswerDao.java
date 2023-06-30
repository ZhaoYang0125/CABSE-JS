package com.cabse.cet.dao;
/*
 * Created with IntelliJ IDEA.
 * ClassName: StudentanswerDao
 * User: 张朝阳
 * Date: 2023/6/3
 * Time: 13:00
 * Description:学生答案接口层
 */

import com.cabse.cet.entity.Report;
import com.cabse.cet.entity.Studentanswer;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentanswerDao extends JpaRepository<Studentanswer, Integer> {
    //通过学生id和试卷id来唯一确定学生的答卷吧
    Studentanswer findByPaperidAndExamid(Integer paperid,Integer examid);

    @Select("select * from studentanswers where examid=#{examid}")
    public List<Studentanswer> findByExamid(Integer examid);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Studentanswer a set a.examid = ?2 where a.answerid = ?1")    //  ?2: 表示第二个参数, ?1: 表示第一个参数
    public void modifyExamid(Integer answerid, Integer Examid);

    @Transactional
    void deleteByExamid(Integer examid);

    @Select("select * from studentanswers where paperid=#{paperid}")
    public List<Studentanswer> findByPaperid(Integer paperid);
}
