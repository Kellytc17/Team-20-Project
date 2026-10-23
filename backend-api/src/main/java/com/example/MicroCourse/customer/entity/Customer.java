package com.example.MicroCourse.customer.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.MicroCourse.provider.entity.CourseEnrollment;
import com.example.MicroCourse.provider.entity.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.CascadeType;

@Entity 
@Table(name="customer")
public class Customer {

    //Data fields 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 

    @NotBlank 
    @Size(max = 100)
    @Column(nullable = false, length = 100, unique = true)
    private String userName;
    
    @NotBlank 
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String firstName;

    @NotBlank 
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String lastName; 

    @NotBlank 
    @Email 
    @Size(max = 100)
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Size(max = 15)
    @Column(length = 15)
    private String phoneNumber;

    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ElementCollection 
    private List<String> interests = new ArrayList<>();  

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Review> reviews = new ArrayList<>(); 
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<CourseEnrollment> courseEnrollments = new ArrayList<>();

    //Constructor(s)
    public Customer(){

    }

    public Customer(Long id, String userName, String password, String firstName, String lastName, String phoneNumber, String email, List<String> interests){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.interests = interests;
    }

//Methods
    //Setters and Getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<CourseEnrollment> getCourseEnrollments() {
        return courseEnrollments;
    }

    public void setCourseEnrollments(List<CourseEnrollment> courseEnrollments) {
        this.courseEnrollments = courseEnrollments;
    } 

}
