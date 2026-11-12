package com.example.MicroCourse.provider.service;

import com.example.MicroCourse.provider.entity.Instructor;
import com.example.MicroCourse.provider.repository.InstructorRepository;
import com.example.MicroCourse.provider.repository.InstructorAccountRepository;
import com.example.MicroCourse.provider.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorAccountRepository accountRepository;
    private final CourseRepository courseRepository;

    public InstructorService(InstructorRepository instructorRepository, InstructorAccountRepository accountRepository, CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.accountRepository = accountRepository;
        this.courseRepository = courseRepository;
    }

    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Instructor not found with ID: " + id));
    }

    public Instructor updateInstructor(Long id, Instructor updatedInstructor) {
        Instructor existingInstructor = getInstructorById(id);

        existingInstructor.setName(updatedInstructor.getName());
        existingInstructor.setQualifications(updatedInstructor.getQualifications());
        existingInstructor.setAreasOfExpertise(updatedInstructor.getAreasOfExpertise());
        existingInstructor.setProfileDescription(updatedInstructor.getProfileDescription());

        return instructorRepository.save(existingInstructor);
    }

    public void deleteInstructor(Long id) {
        Instructor instructor = getInstructorById(id);
        accountRepository.deleteByInstructor_Id(id);
        courseRepository.deleteByInstructor_Id(id);
        instructorRepository.delete(instructor);
    }
}
