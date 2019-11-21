package com.sumutella.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author sumutella
 * @time 8:24 AM
 * @since 11/20/2019, Wed
 */

@Entity
@Table(name = "INSTRUCTORS")
public class Instructor {

    @Id
    @SequenceGenerator(name = "seqInstructor", sequenceName = "INSTRUCTORS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqInstructor")
    private Integer id;
    @Column(name = "FULL_NAME")
    private String fullName;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail")
    private Detail detail;


    @OneToMany(mappedBy = "instructor", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    private List<Course> courses =new ArrayList<>();

    public Instructor() {
    }

    public Instructor(String fullName, String email) {
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

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    public void addCourse(Course course){
        courses.add(course);
        course.setInstructor(this);
    }


    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", detail=" + detail +
                ", courses=" + courses +
                '}';
    }
}
