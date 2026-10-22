package com.example.MicroCourse.provider.repository;

import com.example.MicroCourse.provider.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByInstructor_Id(Long instructorId);

    List<Review> findByCustomerId(Long customerId);
}
