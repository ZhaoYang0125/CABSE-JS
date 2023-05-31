package com.cabse.cet.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "testpapers")
public class Testpaper {
    @Id     // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 自动增长
    private Integer paperid;
    @Column(length = 50)    // 长度
    private String url;

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
        if (!(o instanceof Testpaper)) return false;
        Testpaper testpaper = (Testpaper) o;
        return Objects.equals(getPaperid(), testpaper.getPaperid()) &&
                Objects.equals(getUrl(), testpaper.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaperid(), getUrl());
    }
}
