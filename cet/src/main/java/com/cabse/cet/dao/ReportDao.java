package com.cabse.cet.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ReportDao /*extends JpaRepository<Report, Integer>*/ {

    @Update("update reprots r set r.translation=#{translation} where r.paperid=#{paperid} and r.sid=#{sid}")
    public int updateTranslation(Integer paperid, Integer sid, Integer translation);

    @Update("update reprots r set r.writing=#{writing} where r.paperid=#{paperid} and r.sid=#{sid}")
    public int updateWriting( Integer paperid, Integer sid, Integer writing);
}
