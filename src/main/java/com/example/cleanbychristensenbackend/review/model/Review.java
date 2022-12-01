package com.example.cleanbychristensenbackend.review.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Antal stjerner
     */
    @Column(name = "amountofstars")
    private Double amountOfStars;

    /**
     * Review besked
     */
    @Column(name = "reviewmessage")
    private String reviewMessage;


    /**
     * Konstruerer en ny review.
     *
     */
    public Review(Double amountOfStars, String reviewMessage) {
        this.amountOfStars = amountOfStars;
        this.reviewMessage = reviewMessage;
    }

    public Review updateFrom(Review review, boolean partial) {
        if (!partial || review.amountOfStars != null) {
            this.amountOfStars = review.amountOfStars;
        }
        if (!partial || review.reviewMessage != null) {
            this.reviewMessage = review.reviewMessage;
        }
        return this;
    }

    /**
     * toString
     */
    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", amountOfStars=" + amountOfStars +
                ", reviewMessage='" + reviewMessage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review review)) return false;
        return getId().equals(review.getId()) && getAmountOfStars().equals(review.getAmountOfStars()) && getReviewMessage().equals(review.getReviewMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmountOfStars(), getReviewMessage());
    }
}

