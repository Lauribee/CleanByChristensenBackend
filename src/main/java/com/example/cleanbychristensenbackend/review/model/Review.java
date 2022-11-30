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
@Table(name = "REVIEWS")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Antal stjerner
     */
    @Column(name = "AMOUNTOFSTARS")
    private Double amountOfStars;

    /**
     * Review besked
     */
    @Column(name = "REVIEWMESSAGE")
    private String reviewMessage;


    /**
     * Konstruerer en ny review.
     *
     * @param amountOfStars
     * @param reviewMessage
     */
    public Review(double amountOfStars, String reviewMessage) {
        this.amountOfStars = amountOfStars;
        this.reviewMessage = reviewMessage;
    }

    public Review updateFrom(Review review, boolean partial) {
        if (!partial || review.amountOfStars != 0) {this.amountOfStars = review.amountOfStars;}
        if (!partial || review.reviewMessage != null) {this.reviewMessage = review.reviewMessage;}
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
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Double.compare(review.amountOfStars, amountOfStars) == 0 && Objects.equals(id, review.id) && Objects.equals(reviewMessage, review.reviewMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amountOfStars, reviewMessage);
    }
}

