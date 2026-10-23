package com.example.MicroCourse.provider.service;

import com.example.MicroCourse.provider.entity.Course;
import com.example.MicroCourse.provider.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Course not found with ID: " + id));
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        Course existingCourse = getCourseById(id);

        existingCourse.setTitle(updatedCourse.getTitle());
        existingCourse.setDescription(updatedCourse.getDescription());
        existingCourse.setTopic(updatedCourse.getTopic());
        existingCourse.setPrice(updatedCourse.getPrice());
        existingCourse.setDurationInHours(updatedCourse.getDurationInHours());
        existingCourse.setInstructor(updatedCourse.getInstructor());

        return courseRepository.save(existingCourse);
    }

    public void deleteCourse(Long id) {
        Course course = getCourseById(id);
        courseRepository.delete(course);
    }
}