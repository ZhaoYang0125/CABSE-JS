package com.cabse.cet.dao;

import com.cabse.cet.entity.Paperanswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperanswerDao extends JpaRepository<Paperanswer, Integer> {
    Paperanswer findByPaperid(Integer paperid);
}
