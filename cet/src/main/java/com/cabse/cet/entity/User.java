package com.cabse.cet.entity;

import javax.persistence.*;
<<<<<<< HEAD
import java.io.Serializable;
=======

>>>>>>> 12b034c2812629d7e01993e4b12de100c48a99fd

/**
 * @ClassName: User
 * @PackageName:com.cabse.cet.entity
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/5/21 19:42
 * @Version 1.0.0
 */

@Table(name = "user")
@Entity
<<<<<<< HEAD
public class User implements Serializable {
=======
public class User{
>>>>>>> 12b034c2812629d7e01993e4b12de100c48a99fd
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

<<<<<<< HEAD
    private String userName;

    private String passWord;

    private Integer state;


=======
    private String username;

    private String password;

    private Integer state;

>>>>>>> 12b034c2812629d7e01993e4b12de100c48a99fd
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

<<<<<<< HEAD
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
=======
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
>>>>>>> 12b034c2812629d7e01993e4b12de100c48a99fd
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
<<<<<<< HEAD

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", state=" + state +
                '}';
    }
=======
>>>>>>> 12b034c2812629d7e01993e4b12de100c48a99fd
}
