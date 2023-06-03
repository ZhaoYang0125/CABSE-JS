package com.cabse.cet.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reprots")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportid;
    private Integer sid;
    private Integer paperid;
    private Integer listening;
    private Integer comprehension;
    private Integer writing;
    private Integer translation;
    private LocalDateTime time;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public Integer getListening() {
        return listening;
    }

    public void setListening(Integer listening) {
        this.listening = listening;
    }

    public Integer getComprehension() {
        return comprehension;
    }

    public void setComprehension(Integer comprehension) {
        this.comprehension = comprehension;
    }
}
