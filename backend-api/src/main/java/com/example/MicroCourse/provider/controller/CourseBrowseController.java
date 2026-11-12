package com.example.MicroCourse.provider.controller;

import com.example.MicroCourse.provider.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class CourseBrowseController {
    private final CourseService courseService;
    public CourseBrowseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public String showAllCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";
    }

    @GetMapping 
    public String showHomePage() {
        return "index";
    }


}
