package com.cabse.cet.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "studentanswers")
public class Studentanswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer answerid;
//    @ManyToOne(
//            targetEntity = Testpaper.class, //与该实体类关联的目标实体类
//            cascade = CascadeType.ALL //同时选择级联新建、删除、刷新、更新
//    )
//    @JoinColumn(
//            name = "paperid", //指定Studentanswer表的paperid列作为外键与Testpaper表对应的paperid列进行关联
//            referencedColumnName = "paperid" //指定参考的主键
//    )
//    @Column(name = "paperid")
    private Integer paperid;
//    @ManyToOne(
//            targetEntity = Studentprofile.class, //与该实体类关联的目标实体类
//            cascade = CascadeType.ALL //同时选择级联新建、删除、刷新、更新
//    )
//    @JoinColumn(
//            name = "examid", //指定Studentanswer表的paperid列作为外键与Testpaper表对应的paperid列进行关联
//            referencedColumnName = "examid" //指定参考的主键
//    )
//    @Column(name = "examid")
    private Integer examid;
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

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
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
        if (o == null || getClass() != o.getClass()) return false;
        Studentanswer that = (Studentanswer) o;
        return Objects.equals(answerid, that.answerid) &&
                Objects.equals(paperid, that.paperid) &&
                Objects.equals(examid, that.examid) &&
                Objects.equals(time, that.time) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerid, paperid, examid, time, url);
    }
}
