package com.example.MicroCourse.provider.controller;

import com.example.MicroCourse.provider.entity.CourseEnrollment;
import com.example.MicroCourse.provider.service.CourseEnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-enrollments")
public class CourseEnrollmentController {

    private final CourseEnrollmentService enrollmentService;

    public CourseEnrollmentController(
            CourseEnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseEnrollment createEnrollment(
            @RequestBody CourseEnrollment enrollment) {
        return enrollmentService.createEnrollment(enrollment);
    }

    @GetMapping
    public List<CourseEnrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public CourseEnrollment getEnrollmentById(@PathVariable Long id) {
        return enrollmentService.getEnrollmentById(id);
    }

    @GetMapping("/course/{courseId}")
    public List<CourseEnrollment> getEnrollmentsByCourse(
            @PathVariable Long courseId) {
        return enrollmentService.getEnrollmentsByCourse(courseId);
    }

    @GetMapping("/customer/{customerId}")
    public List<CourseEnrollment> getEnrollmentsByCustomer(
            @PathVariable Long customerId) {
        return enrollmentService.getEnrollmentsByCustomer(customerId);
    }

    @PutMapping("/{id}")
    public CourseEnrollment updateEnrollment(
            @PathVariable Long id,
            @RequestBody CourseEnrollment enrollment) {
        return enrollmentService.updateEnrollment(id, enrollment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
    }
}
