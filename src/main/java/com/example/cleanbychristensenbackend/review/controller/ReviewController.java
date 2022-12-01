package com.example.cleanbychristensenbackend.review.controller;

import com.example.cleanbychristensenbackend.dto.ReviewDto;
import com.example.cleanbychristensenbackend.factory.DtoFactory;
import com.example.cleanbychristensenbackend.review.model.Review;
import com.example.cleanbychristensenbackend.review.service.ReviewService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/reviews")
public class ReviewController {

    private final ReviewService service;


    public ReviewController(ReviewService service) {
        this.service = service;
    }

    /**
     * Henter/finder alle reviews.
     *
     * @return reviews
     */
    @GetMapping
    ResponseEntity<List<ReviewDto>> findAll() {
        List<Review> all = (List<Review>) service.findAll();
        return ResponseEntity.ok().body(DtoFactory.fromReviews(all));
    }

    /**
     * Henter/finder alle reviews og sorterer dem efter antal stjerner(flest først).
     *
     * @return reviews
     */
    @GetMapping("/orderbyrating")
    ResponseEntity<List<ReviewDto>> findAllOrderByRating() {
        List<Review> all = (List<Review>) service.findAllOrderByRating();
        return ResponseEntity.ok().body(DtoFactory.fromReviews(all));
    }

    /**
     * Henter finder et enkelt review.
     *
     * @param id
     * @return customer
     * @throws ResourceNotFoundException
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> find(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Optional<Review> item = Optional.of(service.find(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review %d not found.".formatted(id))));
        return ResponseEntity.ok().body(DtoFactory.fromReview(item.get()));
    }

    /**
     * Putter/opdaterer et review.
     *
     * @param id
     * @param dto
     * @return opdateret review
     */
    @PutMapping("/{id}")
    public ResponseEntity<ReviewDto> put(@PathVariable("id") Long id, @Valid @RequestBody ReviewDto dto) {
        return ResponseEntity.ok().body(update(id, dto, false));
    }

    /**
     * Patcher et review.
     *
     * @param id
     * @param dto
     * @return opdateret review
     */
    @PatchMapping("/{id}")
    public ResponseEntity<ReviewDto> patch(@PathVariable("id") Long id, @Valid @RequestBody ReviewDto dto) {
        return ResponseEntity.ok().body(update(id, dto, true));
    }

    /**
     * Tilføjer/skaber et review.
     *
     * @param dto
     * @return ny review
     */
    @PostMapping
    public ResponseEntity<ReviewDto> create(@Valid @RequestBody ReviewDto dto) {
        Review item = service.create(DtoFactory.fromReviewDto(dto));
        return ResponseEntity.ok().body(DtoFactory.fromReview(item));
    }

    /**
     * Opdaterer en ReviewDto fra en anden ReviewDto.
     *
     * @param id
     * @param dto
     * @return den opdaterede reviewDto
     */
    private ReviewDto update(Long id, ReviewDto dto, boolean partial) {
        Optional<Review> item = Optional.ofNullable(service.update(id, DtoFactory.fromReviewDto(dto), partial).orElseThrow(() -> {
            throw new ResourceNotFoundException("Review %d ikke fundet".formatted(id));
        }));
        return DtoFactory.fromReview(item.get());
    }

    /**
     * Sletter et review.
     *
     * @param id
     * @return et review med værdien null
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Review> delete(@PathVariable("id") Long id) {
        service.find(id).orElseThrow(() -> new ResourceNotFoundException("Review %d ikke fundet.".formatted(id)));

        Review delete = service.delete(id);
        return ResponseEntity.ok().body(delete);
    }
}
