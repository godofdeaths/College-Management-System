package com.cms.model;

import javax.persistence.*;

@Entity
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String department;
    private Long facultyId;

    // getters & setters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getDepartment(){return department;}
    public void setDepartment(String department){this.department=department;}
    public Long getFacultyId(){return facultyId;}
    public void setFacultyId(Long facultyId){this.facultyId=facultyId;}
}
