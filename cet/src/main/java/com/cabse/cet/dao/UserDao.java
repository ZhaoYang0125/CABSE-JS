package com.cabse.cet.dao;

import com.cabse.cet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
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
<<<<<<< HEAD
    User findByUserName(String userName);
    User findByUserNameAndPassWord(String userName, String passWord);
=======
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
>>>>>>> 12b034c2812629d7e01993e4b12de100c48a99fd

}
