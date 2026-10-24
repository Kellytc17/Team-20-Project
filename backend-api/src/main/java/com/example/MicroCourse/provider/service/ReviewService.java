package com.example.MicroCourse.provider.service;

import com.example.MicroCourse.provider.entity.Instructor;
import com.example.MicroCourse.provider.entity.Review;
import com.example.MicroCourse.provider.repository.InstructorRepository;
import com.example.MicroCourse.provider.repository.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final InstructorRepository instructorRepository;

    public ReviewService(
            ReviewRepository reviewRepository,
            InstructorRepository instructorRepository) {
        this.reviewRepository = reviewRepository;
        this.instructorRepository = instructorRepository;
    }

    public Review createReview(Review review) {
        validateRating(review.getRating());

        if (review.getInstructor() == null
                || review.getInstructor().getId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "An instructor ID is required.");
        }

        Long instructorId = review.getInstructor().getId();

        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Instructor not found."));

        review.setInstructor(instructor);
        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Review not found."));
    }

    public List<Review> getReviewsByInstructor(Long instructorId) {
        if (!instructorRepository.existsById(instructorId)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Instructor not found.");
        }

        return reviewRepository.findByInstructor_Id(instructorId);
    }

    public List<Review> getReviewsByCustomer(Long customerId) {
        return reviewRepository.findByCustomer_Id(customerId);
    }

    public Review updateReview(Long id, Review updatedReview) {
        Review existing = getReviewById(id);

        validateRating(updatedReview.getRating());

        existing.setRating(updatedReview.getRating());
        existing.setComment(updatedReview.getComment());

        return reviewRepository.save(existing);
    }

    public Review replyToReview(Long id, String reply) {
        Review existing = getReviewById(id);
        existing.setReply(reply);
        return reviewRepository.save(existing);
    }

    public void deleteReview(Long id) {
        Review existing = getReviewById(id);
        reviewRepository.delete(existing);
    }

    private void validateRating(Integer rating) {
        if (rating == null || rating < 1 || rating > 5) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Rating must be between 1 and 5.");
        }
    }
}