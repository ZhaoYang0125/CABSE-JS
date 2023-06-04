package com.cabse.cet.dao;
/*
 * Created with IntelliJ IDEA.
 * ClassName: StudentanswerDao
 * User: 张朝阳
 * Date: 2023/6/3
 * Time: 13:00
 * Description:学生答案接口层
 */

import com.cabse.cet.entity.Studentanswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentanswerDao extends JpaRepository<Studentanswer, Integer> {
    //通过学生id和试卷id来唯一确定学生的答卷吧
    Studentanswer findByPaperidAndSid(Integer paperid,Integer sid);
}
