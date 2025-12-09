package com.cms.model;

import javax.persistence.*;

@Entity
public class Marks {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentId;
    private Long courseId;
    private Integer internalMarks;
    private Integer externalMarks;

    // getters & setters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Long getStudentId(){return studentId;}
    public void setStudentId(Long studentId){this.studentId=studentId;}
    public Long getCourseId(){return courseId;}
    public void setCourseId(Long courseId){this.courseId=courseId;}
    public Integer getInternalMarks(){return internalMarks;}
    public void setInternalMarks(Integer internalMarks){this.internalMarks=internalMarks;}
    public Integer getExternalMarks(){return externalMarks;}
    public void setExternalMarks(Integer externalMarks){this.externalMarks=externalMarks;}
}
