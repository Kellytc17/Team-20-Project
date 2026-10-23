package com.example.MicroCourse.provider.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course_enrollments")
public class CourseEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String status;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public CourseEnrollment() {
    }

    public CourseEnrollment(String status, Long customerId, Course course) {
        this.status = status;
        this.customerId = customerId;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
