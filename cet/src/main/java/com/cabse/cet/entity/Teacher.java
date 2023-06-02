package com.cabse.cet.entity;

import javax.persistence.*;


/**
 * @ClassName: User
 * @PackageName:com.cabse.cet.entity
 * @Description: TODO
 * @Author LiuSiyang
 * @Date 2023/5/21 19:42
 * @Version 1.0.0
 */

@Table(name = "teacher")
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    private String username;

    private String password;

    private Integer state;

    public Integer getUid() {
        return tid;
    }

    public void setUid(Integer uid) {
        this.tid = uid;
    }

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
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
