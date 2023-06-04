package com.cabse.cet.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportid;
    private Integer sid;
    private Integer paperid;
    private Float listening;
    private Float comprehension;
    private Float writing;
    private Float translation;
    private LocalDateTime time;

    public Float getListening() {
        return listening;
    }

    public void setListening(Float listening) {
        this.listening = listening;
    }

    public Float getComprehension() {
        return comprehension;
    }

    public void setComprehension(Float comprehension) {
        this.comprehension = comprehension;
    }

    public Float getWriting() {
        return writing;
    }

    public void setWriting(Float writing) {
        this.writing = writing;
    }

    public Float getTranslation() {
        return translation;
    }

    public void setTranslation(Float translation) {
        this.translation = translation;
    }

    public Integer getReportid() {
        return reportid;
    }

    public void setReportid(Integer reportid) {
        this.reportid = reportid;
    }

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



    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return Objects.equals(reportid, report.reportid) &&
                Objects.equals(sid, report.sid) &&
                Objects.equals(paperid, report.paperid) &&
                Objects.equals(listening, report.listening) &&
                Objects.equals(comprehension, report.comprehension) &&
                Objects.equals(writing, report.writing) &&
                Objects.equals(translation, report.translation) &&
                Objects.equals(time, report.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportid, sid, paperid, listening, comprehension, writing, translation, time);
    }
}
