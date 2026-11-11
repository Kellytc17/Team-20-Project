package com.example.MicroCourse.provider.repository;

import com.example.MicroCourse.provider.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByInstructor_Id(Long instructorId);
}