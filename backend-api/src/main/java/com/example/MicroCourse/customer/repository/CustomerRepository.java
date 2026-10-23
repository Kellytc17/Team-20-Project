package com.example.MicroCourse.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MicroCourse.customer.entity.Customer;

@Repository 
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmailIgnoreCase(String email);
    boolean existsByUserNameIgnoreCase(String userName);

    Optional<Customer> findByEmailIgnoreCase(String email);

    Optional<Customer> findByUserNameIgnoreCase(String userName);
}
