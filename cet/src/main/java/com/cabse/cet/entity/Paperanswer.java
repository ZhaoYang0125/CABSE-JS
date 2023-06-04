package com.cabse.cet.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "paperanswers")
public class Paperanswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer answerid;
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
        if (this == o) {return true;}
        if (!(o instanceof Paperanswer)) {return false;}
        Paperanswer that = (Paperanswer) o;
        return Objects.equals(getAnswerid(), that.getAnswerid()) &&
                Objects.equals(getPaperid(), that.getPaperid()) &&
                Objects.equals(getUrl(), that.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnswerid(), getPaperid(), getUrl());
    }
}
