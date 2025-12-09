package com.cms.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Notice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length=2000)
    private String content;
    private LocalDate date;

    // getters & setters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}
    public String getContent(){return content;}
    public void setContent(String content){this.content=content;}
    public LocalDate getDate(){return date;}
    public void setDate(LocalDate date){this.date=date;}
}
