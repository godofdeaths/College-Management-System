package com.cms.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Fee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentId;
    private Double amount;
    private LocalDate date;
    private String status; // Paid/Unpaid

    // getters & setters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Long getStudentId(){return studentId;}
    public void setStudentId(Long studentId){this.studentId=studentId;}
    public Double getAmount(){return amount;}
    public void setAmount(Double amount){this.amount=amount;}
    public LocalDate getDate(){return date;}
    public void setDate(LocalDate date){this.date=date;}
    public String getStatus(){return status;}
    public void setStatus(String status){this.status=status;}
}
