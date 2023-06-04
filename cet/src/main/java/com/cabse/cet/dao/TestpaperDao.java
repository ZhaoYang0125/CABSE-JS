package com.cabse.cet.dao;

import com.cabse.cet.entity.Testpaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestpaperDao extends JpaRepository<Testpaper, Integer> {

}
