package com.cabse.cet.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "studentprofiles")
public class studentprofile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private Integer sid;
    // @Column(length = 20)
    // private String name;
    private enum Sex{ 男, 女};
    private Sex gender; //  实际存储值为索引，0为男，1为女

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof studentprofile)) return false;
        studentprofile that = (studentprofile) o;
        return Objects.equals(getUid(), that.getUid()) &&
                Objects.equals(getSid(), that.getSid()) &&
                getGender() == that.getGender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid(), getSid(), getGender());
    }
}
