package com.example.MicroCourse.provider.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String qualifications;

    private String areasOfExpertise;

    @Column(length = 1000)
    private String profileDescription;

    public Instructor() {
    }

    public Instructor(String name, String qualifications,
                      String areasOfExpertise, String profileDescription) {
        this.name = name;
        this.qualifications = qualifications;
        this.areasOfExpertise = areasOfExpertise;
        this.profileDescription = profileDescription;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getAreasOfExpertise() {
        return areasOfExpertise;
    }

    public void setAreasOfExpertise(String areasOfExpertise) {
        this.areasOfExpertise = areasOfExpertise;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }
}
