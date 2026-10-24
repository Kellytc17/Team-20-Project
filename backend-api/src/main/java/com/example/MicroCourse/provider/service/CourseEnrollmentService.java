package com.example.MicroCourse.provider.service;

import com.example.MicroCourse.provider.entity.Course;
import com.example.MicroCourse.provider.entity.CourseEnrollment;
import com.example.MicroCourse.provider.repository.CourseEnrollmentRepository;
import com.example.MicroCourse.provider.repository.CourseRepository;
import org.springframework.stereotype.Service;
import com.example.MicroCourse.customer.entity.Customer;
import com.example.MicroCourse.customer.repository.CustomerRepository;


import java.util.List;

@Service
public class CourseEnrollmentService {

    private final CourseEnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final CustomerRepository customerRepository;

    public CourseEnrollmentService(
            CourseEnrollmentRepository enrollmentRepository,
            CourseRepository courseRepository,
            CustomerRepository customerRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
        this.customerRepository = customerRepository;
    }

    public CourseEnrollment createEnrollment(CourseEnrollment enrollment) {
        if (enrollment.getCustomer() == null
                || enrollment.getCustomer().getId() == null) {
            throw new IllegalArgumentException("A customer ID is required.");
        }

        Long customerId = enrollment.getCustomer().getId();

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found: " + customerId));

        enrollment.setCustomer(customer);
         
        if (enrollment.getCourse() == null
                || enrollment.getCourse().getId() == null) {
            throw new IllegalArgumentException("A course ID is required.");
        }

        Long courseId = enrollment.getCourse().getId();

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() ->
                        new RuntimeException("Course not found: " + courseId));

        enrollment.setCourse(course);

        return enrollmentRepository.save(enrollment);
    }

    public List<CourseEnrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public CourseEnrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Enrollment not found: " + id));
    }

    public List<CourseEnrollment> getEnrollmentsByCourse(Long courseId) {
        return enrollmentRepository.findByCourse_Id(courseId);
    }

    public List<CourseEnrollment> getEnrollmentsByCustomer(Long customerId) {
        return enrollmentRepository.findByCustomer_Id(customerId);
    }

    public CourseEnrollment updateEnrollment(
            Long id, CourseEnrollment updatedEnrollment) {

        CourseEnrollment existing = getEnrollmentById(id);

        existing.setStatus(updatedEnrollment.getStatus());

          if (updatedEnrollment.getCustomer() != null
                && updatedEnrollment.getCustomer().getId() != null) {

            Long customerId = updatedEnrollment.getCustomer().getId();

            Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(() ->
                            new RuntimeException("Customer not found: " + customerId));

            existing.setCustomer(customer);
        }

        if (updatedEnrollment.getCourse() != null
                && updatedEnrollment.getCourse().getId() != null) {

            Long courseId = updatedEnrollment.getCourse().getId();

            Course course = courseRepository.findById(courseId)
                    .orElseThrow(() ->
                            new RuntimeException("Course not found: " + courseId));

            existing.setCourse(course);
        }

        return enrollmentRepository.save(existing);
    }

    public void deleteEnrollment(Long id) {
        CourseEnrollment enrollment = getEnrollmentById(id);
        enrollmentRepository.delete(enrollment);
    }
}
