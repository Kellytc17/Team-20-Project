
# Requirements – Starter Template

**Project Name:** MicroCourse \
**Team:** Kelly Clark - Provider, Ulises Martinez Zuniga - Customer  \
**Course:** CSC 340\
**Version:** 1.0\
**Date:** 2026-09-18

---

## 1. Overview
**Vision.** MicroCourse is a platform for studenst and professionals who want to explore short and local courses provided by experts in multiple fields. The system simplifies learning by providing structured and concise course material that is easy to follow. 

**Glossary** Terms used in the project
- **Learner:** A student who searches and enrolls in courses. 
- **Instructor:** An expert who creates, publishes, and manages courses for learners. 
- **Course:** A short structured learning experience created and provided by an instructor.
- **Course Cohort:** A group of learners enrolled in the same course.

**Primary Users / Roles.**
- **Learner** — Find and enroll in short courses that provide structured and easy to follow learning material.
- **Instructor** — Create, publish, and manage courses to provide learning.

**Scope (this semester).**
- User profiles (learners and instructors)
- Search and browse courses by instructors and keywords
- Reviews, ratings, and comments
- Course progression tracking 
- Adding courses to a customer's profile

**Out of scope (deferred).**
- E-commerce and payment functionality 
- Direct in-app communication between learners and instructors

> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)
Write each story as: **As a `<role>`, I want `<capability>`, so that `<benefit>`.** Each story includes at least one **Given/When/Then** scenario.

### 2.1 Customer Stories
- **US‑1 — <Sign-up & manage profile>**  
  _Story:_ As a customer, I want to create a user profile, so that I can easily find and enroll in courses
  _Acceptance:_
  ```gherkin
  Scenario: Sign-up and input information
    Given I am a user without a profile 
    When  I provide vaid sign-up details
    Then  I should be successfully registered and logged in
  ```

- **US‑2 — <Write a review after a course>**  
  _Story:_ As a customer, I want to write a review so that other users can view it and benefit  
  _Acceptance:_
  ```gherkin
  Scenario: Write a review after a course
    Given I have completed a registered course 
    When  I submit a review for that course 
    Then  The review should be saved and visible to other customers
  ```

  - **US‑3 — <short title>**  
  _Story:_ As a customer, I want to be able to filter through courses so that I can find courses tailored to my interests   
  _Acceptance:_
  ```gherkin
  Scenario: I am searching for a course 
    Given I select the filter tab
    When  I apply the filters 
    Then  I will see tailored courses based on my preferences 
  ```

  - **US‑4 — <Enroll in a course>**  
  _Story:_ As a customer, I want to enroll in courses so that I can expand my knowledge
  _Acceptance:_
  ```gherkin
  Scenario: I am logged into my user profile
    Given I select the course I want from the course catalog
    When  I click 'enroll' 
    Then  I will be able to see the course material 
  ```

### 2.2 Provider Stories
- **US-5 — Create Instructor Profile**  
  _Story:_ As an instuctor, I want to create a profile so that I can attract users to my courses. 
  _Acceptance:_
  ```gherkin
  Scenario: Create an instructor profile
    Given I am an instructor without a profile
    When  I provide my instrutcor information and submit the profile 
    Then  My instructor profile should be created and visible to custormers
  ```

  - **US-5 — Create Instructor Profile**  
  _Story:_ As an instuctor, I want to create a profile so that I can attract users to my courses. 
  _Acceptance:_
  ```gherkin
  Scenario: Create an instructor profile
    Given I am an instructor without a profile
    When  I provide my instrutcor information and submit the profile 
    Then  My instructor profile should be created and visible to custormers
  ```
- **US-5 — Create Instructor Profile**  
  _Story:_ As an instuctor, I want to create a profile so that I can attract users to my courses. 
  _Acceptance:_
  ```gherkin
  Scenario: Create an instructor profile
    Given I am an instructor without a profile
    When  I provide my instrutcor information and submit the profile 
    Then  My instructor profile should be created and visible to custormers
  ```

- **US-6 — Publish Courses**  
  _Story:_ As an instructor, I want to publish my courses so that customers can understand what I offer and the pricing.  
  _Acceptance:_
  ```gherkin
  Scenario: Publish a course
    Given I am logged in as an instructor
    When  I provide the course information and pricing and publish the  course
    Then  The course should be available for customers to view
  ```

  **US-7 — Manage Reviews**  
  _Story:_ As an instructor, I want to view and manage reviews so that I can engage with customers.  
  _Acceptance:_
  ```gherkin
  Scenario: Manage course reviews
    Given I am logged in as an instructor
    When  I access the reviews for one of my courses 
    Then  I should be able to view the reviews and respond to them 
  ```

  **US-8 — Manage Courses**  
  _Story:_ As an instructor, I want to manage my courses so that customers can have the most relevant information.  
  _Acceptance:_
  ```gherkin
  Scenario: Update course information
    Given I am logged in as an instructor
    When  I update information for one of my courses
    Then  The updated course information should be visible to customers
  ```

**US-9 — Manage Enrolled Learners**  
  _Story:_ As an instructor, I want to manage enrolled learners so that I can manage my course cohorts.  
  _Acceptance:_
  ```gherkin
  Scenario: Manage enrolled learners
    Given I am logged in as an instructor and learners are enrolled in my course
    When  I view the enrolled learners
    Then  I should be able to view and manage the learners in my course cohort
  ```
---

## 3. Non‑Functional Requirements (make them measurable)
- **Performance:** Course search and browsing results should be displayed within 2 seconds under normal system usage.
- **Availability/Reliability:** The system should remain available during normal usage and should save user, course, enrollment, and progress information without unexpected loss.
- **Security/Privacy:** Users must authenticate before accessing their profiles and personal course information. User information should only be accessible to authorized users.
- **Usability:** A new customer should be able to create a profile and find a course using the search or browse features without external assistance.

---

## 4. Assumptions, Constraints, and Policies
- Users are expected to have access to a modern web browser and a stable internet connection.
- Customers and instructors are expected to provide accurate information in their profiles and course content.
- The project must be completed within the CSC 340 course timeline and project requirements.
- E-commerce and direct in-app communication between customers and instructors are outside the scope of the current project.

---

## 5. Milestones (course‑aligned)
- **M1 Requirements** — this file + stories opened as issues. 
- **M2 High‑fidelity prototype** — core customer/provider flows fully interactive. 
- **M3 Design** — architecture, schema, API outline. 
- **M4 Backend API** — key endpoints + tests. 
- **M5 Increment** — ≥2 use cases end‑to‑end. 
- **M6 Final** — complete system & documentation. 

---

## 6. Change Management
- Stories are living artifacts; changes are tracked via repository issues and linked pull requests.  
- Major changes should update this SRS.