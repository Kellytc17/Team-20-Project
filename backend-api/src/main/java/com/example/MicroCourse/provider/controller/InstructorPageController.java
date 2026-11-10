package com.example.MicroCourse.provider.controller;

import com.example.MicroCourse.provider.entity.Instructor;
import com.example.MicroCourse.provider.service.InstructorService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;

import jakarta.validation.Valid;



@Controller 
@RequestMapping("/instructors")
public class InstructorPageController {
    private final InstructorService instructorService;
    public InstructorPageController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "instructor-signup";
    }

    @PostMapping("/signup")
    public String createInstructor(
        @Valid @ModelAttribute Instructor instructor, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
            if(bindingResult.hasErrors()){
                model.addAttribute("instructor", instructor);
                model.addAttribute("errors", bindingResult.getFieldErrors());
                return "instructor-signup";
            }
      Instructor savedInstructor = instructorService.createInstructor(instructor);
      redirectAttributes.addFlashAttribute("successMessage", "Instructor profile created successfully");
      return "redirect:/instructors/signup" + savedInstructor.getId();      
        
    }

    @GetMapping("/{id}")
    public String showInstructorProfile(
        @org.springframework.web.bind.annotation.PathVariable Long id,
        Model model) {

    Instructor instructor = instructorService.getInstructorById(id);
    model.addAttribute("instructor", instructor);

    return "instructor-profile";
}

    
}
