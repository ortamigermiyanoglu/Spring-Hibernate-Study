package com.sumutella.entity;

import javax.persistence.*;

/**
 * @author sumutella
 * @time 10:16 PM
 * @since 11/24/2019, Sun
 */

@Entity
@Table(name = "reviews")
public class Review {


    @Id
    @SequenceGenerator(name = "seqReview", sequenceName = "REVIEWS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReview")
    private Integer id;
    private String review;

    public Review() {
    }

    public Review(String review) {
        this.review = review;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", review='" + review + '\'' +
                '}';
    }
}
