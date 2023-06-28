package com.cabse.cet.entity;

import javax.persistence.*;
import java.util.Objects;


@Table(name = "studentprofiles")
@Entity
public class Studentprofile {

    private Integer uid;
    @Id
    private Integer examid;
    // @Column(length = 20)
    private String sname;
//    public enum Sex{ 男, 女};
    private String gender; //  实际存储值为索引，0为男，1为女
    private Integer age;
    private String school;
    private String majerity;

    public String getMajerity() {
        return majerity;
    }

    public void setMajerity(String majerity) {
        this.majerity = majerity;
    }

    public String getEnrollmentyear() {
        return enrollmentyear;
    }

    public void setEnrollmentyear(String enrollmentyear) {
        this.enrollmentyear = enrollmentyear;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    private String enrollmentyear;
    private String degree;


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

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studentprofile that = (Studentprofile) o;
        return Objects.equals(uid, that.uid) &&
                Objects.equals(examid, that.examid) &&
                Objects.equals(sname, that.sname) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(age, that.age) &&
                Objects.equals(school, that.school) &&
                Objects.equals(majerity, that.majerity) &&
                Objects.equals(enrollmentyear, that.enrollmentyear) &&
                Objects.equals(degree, that.degree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, examid, sname, gender, age, school, majerity, enrollmentyear, degree);
    }
}
