package com.cabse.cet.entity;

import javax.persistence.*;
import java.util.Objects;


@Table(name = "studentprofiles", uniqueConstraints = {@UniqueConstraint(columnNames="sid")})
@Entity
public class Studentprofile {

    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer uid;

    private Integer sid;
    // @Column(length = 20)
    private String sname;
//    public enum Sex{ 男, 女};
    private String gender; //  实际存储值为索引，0为男，1为女
    private Integer age;
    private String school;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof Studentprofile)) {return false;}
        Studentprofile that = (Studentprofile) o;
        return Objects.equals(getUid(), that.getUid()) &&
                Objects.equals(getSid(), that.getSid()) &&
                getGender() == that.getGender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid(), getSid(), getGender());
    }
}
