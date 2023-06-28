package com.cabse.cet.dao;
/*
 * Created with IntelliJ IDEA.
 * ClassName: ReportDao
 * User: 张朝阳
 * Date: 2023/6/3
 * Time: 12:25
 * Description:学生成绩报告接口层
 */

import com.cabse.cet.entity.Report;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ReportDao /*extends JpaRepository<Report, Integer>*/ {
    @Insert("insert into reports (examid, paperid, listening, comprehension, time)values (#{examid},#{paperid},#{listening},#{comprehension},#{time})")
    public int save(Integer examid, Integer paperid, Float listening, Float comprehension, LocalDateTime time);

    @Update("update reports r set r.translation=#{translation} where r.paperid=#{paperid} and r.examid=#{examid}")
    public int updateTranslation(Integer paperid, Integer examid, Float translation);

    @Update("update reports r set r.writing=#{writing} where r.paperid=#{paperid} and r.examid=#{examid}")
    public int updateWriting( Integer paperid, Integer examid, Float writing);

    @Select("select * from reports where paperid=#{paperid} and examid=#{examid}")
    public Report findByPaperidAndExamid(Integer paperid, Integer examid);

    @Select("select * from reports where examid=#{examid}")
    public List<Report> findByExamid(Integer examid);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Update("update reports r set r.examid =#{examid} where r.reportid =#{reportid}")
    public void modifyExamid(Integer reportid, Integer Examid);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Delete("delete from reports where examid=#{examid}")
    void deleteByExamid(Integer examid);
}
