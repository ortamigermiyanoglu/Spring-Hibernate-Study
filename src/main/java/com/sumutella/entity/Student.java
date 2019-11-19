package com.sumutella.entity;

import javax.persistence.*;

/**
 * @author sumutella
 * @time 8:02 PM
 * @since 11/19/2019, Tue
 */
@Entity
@Table(name = "Students")
public class Student {


    @Id
    @SequenceGenerator(name = "seqStudent", sequenceName = "STUDENTS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqStudent")
    private Integer id;
    @Column(name = "full_name")
    private String fullName;
    private String email;

    public Student() {
    }

    public Student(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
