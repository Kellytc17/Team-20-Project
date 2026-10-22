package com.example.MicroCourse.provider.repository;

import com.example.MicroCourse.provider.entity.CourseEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment, Long> {

    List<CourseEnrollment> findByCustomerId(Long customerId);

    List<CourseEnrollment> findByCourse_Id(Long courseId);
}
