package com.example.MicroCourse.provider.controller;

import com.example.MicroCourse.provider.entity.Review;
import com.example.MicroCourse.provider.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @GetMapping("/instructor/{instructorId}")
    public List<Review> getReviewsByInstructor(
            @PathVariable Long instructorId) {
        return reviewService.getReviewsByInstructor(instructorId);
    }

    @GetMapping("/customer/{customerId}")
    public List<Review> getReviewsByCustomer(
            @PathVariable Long customerId) {
        return reviewService.getReviewsByCustomer(customerId);
    }

    @PutMapping("/{id}")
    public Review updateReview(
            @PathVariable Long id,
            @RequestBody Review review) {
        return reviewService.updateReview(id, review);
    }

    @PutMapping("/{id}/reply")
    public Review replyToReview(
            @PathVariable Long id,
            @RequestBody Map<String, String> request) {

        if (request == null || !request.containsKey("reply")) {
            throw new org.springframework.web.server.ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "A reply field is required.");
        }

        return reviewService.replyToReview(id, request.get("reply"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}
