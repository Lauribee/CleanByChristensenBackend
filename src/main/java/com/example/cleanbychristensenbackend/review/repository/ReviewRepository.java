package com.example.cleanbychristensenbackend.review.repository;

import com.example.cleanbychristensenbackend.review.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    Optional<Review> findById(long id);

    @Query("SELECT r FROM Review r ORDER BY r.amountOfStars desc")
    List<Review> findAllOrderByRating();
}
