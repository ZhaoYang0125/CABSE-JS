package com.cabse.cet.dao;

import com.cabse.cet.entity.Testpaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestpaperDao extends JpaRepository<Testpaper, Integer> {
//    Testpaper findByPaperid(Integer paperid);
//    @Query(value = "INSERT into testpapers(pid, url) values(?1)")
//    public void mySave(String url);
}
