package com.cabse.cet.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "studentanswers")
public class studentanswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer answerid;
    @NotNull
    private Integer paperid;
    @NotNull
    private Integer sid;
    private LocalDateTime time;
    private String url;

    public Integer getAnswerid() {
        return answerid;
    }

    public void setAnswerid(Integer answerid) {
        this.answerid = answerid;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof studentanswer)) return false;
        studentanswer that = (studentanswer) o;
        return Objects.equals(getAnswerid(), that.getAnswerid()) &&
                Objects.equals(getPaperid(), that.getPaperid()) &&
                Objects.equals(getSid(), that.getSid()) &&
                Objects.equals(getTime(), that.getTime()) &&
                Objects.equals(getUrl(), that.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnswerid(), getPaperid(), getSid(), getTime(), getUrl());
    }
}
