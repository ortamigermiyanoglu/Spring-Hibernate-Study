package com.sumutella.entity;

import javax.persistence.*;


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


    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", detail=" + detail +
                '}';
    }
}
