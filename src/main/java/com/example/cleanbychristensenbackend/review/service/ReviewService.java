package com.example.cleanbychristensenbackend.review.service;

import com.example.cleanbychristensenbackend.review.model.Review;
import com.example.cleanbychristensenbackend.review.repository.ReviewRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository repository;

    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    /**
     * Finder alle reviews sat efter deres antal stjerner.
     *
     * @return all reviews
     */
    public Iterable<Review> findAllOrderByRating() {
        List<Review> list = new ArrayList<>();
        Iterable<Review> items = repository.findAllOrderByRating();
        items.forEach(list::add);
        return list;
    }

    /**
     * Finder alle reviews.
     *
     * @return alle reviews
     */
    public Iterable<Review> findAll() {
        List<Review> list = new ArrayList<>();
        Iterable<Review> items = repository.findAll();
        items.forEach(list::add);
        return list;
    }

    public Optional<Review> find(Long id) throws ResourceNotFoundException {
        Optional<Review> review = repository.findById(id);
        return review;
    }

    public Review create(Review review) {
        return repository.save(review);
    }

    public Optional<Review> update(Long id, Review review, boolean partial) {
        return repository.findById(id)
                .map(oldItem -> {
                    return repository.save(oldItem.updateFrom(review, partial));
                });
    }

    public Review delete(Long id) {
        repository.deleteById(id);
        return null;
    }
}


