package com.example.MicroCourse.provider.service;

import com.example.MicroCourse.provider.entity.Instructor;
import com.example.MicroCourse.provider.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
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
        instructorRepository.delete(instructor);
    }
}
