package com.cabse.cet.entity;

import javax.persistence.*;
import java.io.Serializable;

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
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    private String userName;

    private String passWord;

    private Integer state;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

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
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}
