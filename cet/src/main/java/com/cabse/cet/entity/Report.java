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

}
