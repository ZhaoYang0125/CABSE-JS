package com.cabse.cet.dao;

import com.cabse.cet.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: UserDao
 * @PackageName:com.cabse.cet.dao
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/5/21 19:52
 * @Version 1.0.0
 */

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);

    /* 自定义查询 */
//    @Query("select u from user u where username like CONCAT('%', ?1, '%') or uid like ?1") // ?1: 表示第一个参数, CONCAT字符串拼接
//    public Page<User> findByKeyword(String keyword, Pageable pageable);
//
//    @Query("update User u set u.password = ?2 where u.uid = ?1")    //  ?2: 表示第二个参数, ?1: 表示第一个参数
//    public void modifyPassword(Integer uid, String pwd);
}
