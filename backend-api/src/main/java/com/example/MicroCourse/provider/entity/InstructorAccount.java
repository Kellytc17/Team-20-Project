package com.example.MicroCourse.provider.entity;

import jakarta.persistence.*;

@Entity 
public class InstructorAccount {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @OneToOne 
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    public InstructorAccount() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHas(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }


}
