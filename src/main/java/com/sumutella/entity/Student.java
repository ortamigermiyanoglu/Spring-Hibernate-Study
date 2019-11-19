package com.sumutella.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author sumutella
 * @time 8:02 PM
 * @since 11/19/2019, Tue
 */
@Entity
@Table(name = "Students")
public class Student {
    private Integer id;
    @Column(name = "full_name")
    private String fullName;
    private String email;

    public Student() {
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
}
