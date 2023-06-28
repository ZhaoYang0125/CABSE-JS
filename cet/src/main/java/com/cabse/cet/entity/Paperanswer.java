package com.cabse.cet.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "paperanswers")
public class Paperanswer {
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
    @Column(length = 50)
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
        Paperanswer that = (Paperanswer) o;
        return Objects.equals(answerid, that.answerid) &&
                Objects.equals(paperid, that.paperid) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerid, paperid, url);
    }
}
