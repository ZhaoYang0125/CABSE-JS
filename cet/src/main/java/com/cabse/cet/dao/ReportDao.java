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
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;

@Mapper
public interface ReportDao /*extends JpaRepository<Report, Integer>*/ {
    @Insert("insert into reports (sid, paperid, listening, comprehension, time)values (#{sid},#{paperid},#{listening},#{comprehension},#{time})")
    public int save(Integer sid, Integer paperid, Float listening, Float comprehension, LocalDateTime time);

    @Update("update reports r set r.translation=#{translation} where r.paperid=#{paperid} and r.sid=#{sid}")
    public int updateTranslation(Integer paperid, Integer sid, Float translation);

    @Update("update reports r set r.writing=#{writing} where r.paperid=#{paperid} and r.sid=#{sid}")
    public int updateWriting( Integer paperid, Integer sid, Float writing);

    @Select("select * from reports where paperid=#{paperid} and sid=#{sid}")
    public Report findByPaperidAndSid(Integer paperid, Integer sid);
}
