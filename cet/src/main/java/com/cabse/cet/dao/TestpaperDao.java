package com.cabse.cet.dao;

import com.cabse.cet.entity.Testpaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestpaperDao extends JpaRepository<Testpaper, Integer> {
    Testpaper findByPaperid(Integer paperid);

    @Query(value = "select url from Testpaper limit ?1, 1", nativeQuery = true)
    String findByRow(Integer row);

    @Query("select count(paperid) from Testpaper")
    Integer paperCount();
}


