package com.example.MicroCourse.provider.controller;

import com.example.MicroCourse.provider.entity.Course;
import com.example.MicroCourse.provider.entity.Instructor;
import com.example.MicroCourse.provider.service.CourseService;
import com.example.MicroCourse.provider.service.InstructorService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller 
@RequestMapping("/instructors/{instructorId}/courses")
public class CoursePageController {
    private final CourseService courseService;
    private final InstructorService instructorService;

    public CoursePageController(CourseService courseService, InstructorService instructorService) {
        this.courseService = courseService;
        this.instructorService = instructorService;
    }

    @GetMapping("/new")
    public String showCourseForm(@PathVariable Long instructorId, Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("instructorId", instructorId);
        return "course-form";
    }

    @PostMapping 
    public String publishCourse(@PathVariable Long instructorId, @ModelAttribute Course course, RedirectAttributes redirectAttributes) {
        Instructor instructor = instructorService.getInstructorById(instructorId);
        courseService.createCourse(course);
        redirectAttributes.addFlashAttribute("successMessage", "Course published successfully");
        
        return "redirect:/instructor/" + instructorId + "/courses";
    }

    @GetMapping 
    public String showInstructorCourses(@PathVariable Long instructorId, Model model) {
        model.addAttribute("courses", courseService.getCoursesByInstructor(instructorId));
        model.addAttribute("instructorId", instructorId);

        return "instructor-courses";
    }

}
