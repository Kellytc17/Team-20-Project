package com.example.MicroCourse.provider.repository;

import com.example.MicroCourse.provider.entity.InstructorAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstructorAccountRepository extends JpaRepository<InstructorAccount, Long> {
    Optional<InstructorAccount> findByEmail(String email);
    boolean existsByEmail(String email);
}