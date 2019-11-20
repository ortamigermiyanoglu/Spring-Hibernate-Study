package com.sumutella.entity;

/**
 * @author sumutella
 * @time 8:25 AM
 * @since 11/20/2019, Wed
 */
import javax.persistence.*;



@Entity
@Table(name = "DETAILS")
public class Detail {

    @Id
    @SequenceGenerator(name = "seqDetail", sequenceName = "DETAILS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqDetail")
    private Integer id;

    @Column(name = "fb_page")
    private String fbPage;
    private String hobby;

    @OneToOne(mappedBy = "detail", cascade = CascadeType.ALL)
    private Instructor instructor;

    public Detail() {
    }

    public Detail(String fbPage, String hobby) {
        this.fbPage = fbPage;
        this.hobby = hobby;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFbPage() {
        return fbPage;
    }

    public void setFbPage(String fbPage) {
        this.fbPage = fbPage;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", fbPage='" + fbPage + '\'' +
                ", hobby='" + hobby + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}
