package com.cabse.cet.dao;

import com.cabse.cet.entity.Paperanswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperanswerDao extends JpaRepository<Paperanswer, Integer> {
}
