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

@Table(name = "admin")
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aid;

    private String username;

    private String password;

    private Integer state;

    private String token;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public Admin(String username, String password, Integer state, String token) {
        this.username = username;
        this.password = password;
        this.state = state;
        this.token = token;
    }

    public Admin() {
    }
}
