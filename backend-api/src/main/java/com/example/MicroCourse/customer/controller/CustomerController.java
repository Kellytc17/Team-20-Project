package com.example.MicroCourse.customer.controller;

//import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.MicroCourse.customer.entity.Customer;
import com.example.MicroCourse.customer.service.CustomerService;
//import com.example.MicroCourse.provider.entity.CourseEnrollment;
//import com.example.MicroCourse.provider.service.CourseEnrollmentService;
//import com.example.MicroCourse.provider.entity.Review;
//import com.example.MicroCourse.provider.service.CourseEnrollmentService;
//import com.example.MicroCourse.provider.service.ReviewService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;
    // private final CourseEnrollmentService courseEnrollmentService;
    // private final ReviewService reviewService;

    public CustomerController(
            CustomerService customerService) {
            //     CourseEnrollmentService courseEnrollmentService,
            // ReviewService reviewService

        this.customerService = customerService;
        // this.courseEnrollmentService = courseEnrollmentService;
        // this.reviewService = reviewService;
    }

    @PostMapping
    public Customer registerCustomer(
            @RequestBody Customer customer) {

        return customerService.registerCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(
            @PathVariable Long id) {

        return customerService.getCustomer(id);
    }

    @GetMapping("/email/{email}")
    public Customer getCustomerByEmail(
            @PathVariable String email) {

        return customerService.findByEmail(email);
    }

    @GetMapping("/username/{userName}")
    public Customer getCustomerByUserName(
            @PathVariable String userName) {

        return customerService.findByUserName(userName);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(
            @PathVariable Long id,
            @RequestBody Customer customer) {

        return customerService.updateProfile(id, customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(
            @PathVariable Long id) {

        customerService.deleteCustomer(id);
    }

    // @GetMapping("/{customerId}/reviews")
    // public List<Review> getCustomerReviews(
    //         @PathVariable Long customerId) {

    //     return reviewService.getReviewsByCustomer(customerId);
    // }

    // @GetMapping("/{customerId}/enrollments")
    // public List<CourseEnrollment> getCustomerEnrollments(
    //         @PathVariable Long customerId) {

    //     return courseEnrollmentService
    //             .getEnrollmentsByCustomer(customerId);
    // }
}
