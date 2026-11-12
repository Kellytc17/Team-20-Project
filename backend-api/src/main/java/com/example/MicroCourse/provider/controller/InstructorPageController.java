package com.example.MicroCourse.provider.controller;

import com.example.MicroCourse.provider.entity.Instructor;
import com.example.MicroCourse.provider.entity.InstructorAccount;
import com.example.MicroCourse.provider.service.InstructorService;
import com.example.MicroCourse.provider.service.InstructorAccountService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;


@Controller 
@RequestMapping("/instructors")
public class InstructorPageController {
    private final InstructorService instructorService;
    private final InstructorAccountService accountService;
    public InstructorPageController(InstructorService instructorService, InstructorAccountService accountService) {
        this.instructorService = instructorService;
        this.accountService = accountService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "instructor-login";
    }

    @PostMapping("/login")
    public String loginInstructor(@RequestParam String email, @RequestParam String password, Model model) {
        try {
            InstructorAccount account = accountService.getAccountByEmail(email);

            if (!account.getPassword().equals(password)) {
                model.addAttribute("errorMessage", "Incorrect email or password");
                return "instructor-login";
            }

            return "redirect:/instructors/" + account.getInstructor().getId();
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", "Incorrect email or password");
            return "instructor-login";
        }
    }

    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "instructor-signup";
    }

    @PostMapping("/signup")
    public String createInstructor(
        @ModelAttribute Instructor instructor, @RequestParam String email, @RequestParam String password, RedirectAttributes redirectAttributes, Model model) {
            if(accountService.emailExists(email)){
                model.addAttribute("instructor", instructor);
                model.addAttribute("errorMessage", "Email is already registered");
                return "instructor-signup";
            }
      Instructor savedInstructor = instructorService.createInstructor(instructor);
      InstructorAccount account = new InstructorAccount();
      account.setEmail(email);
      account.setPassword(password);
      account.setInstructor(savedInstructor);
      accountService.createAccount(account);
      redirectAttributes.addFlashAttribute("successMessage", "Instructor profile created successfully");
      return "redirect:/instructors/" + savedInstructor.getId();      
        
    }

    @GetMapping
    public String showAllInstructors(Model model) {
        model.addAttribute("instructors", instructorService.getAllInstructors());
        return "instructors";
    }

    @GetMapping("/{id}")
    public String showInstructorProfile(
        @org.springframework.web.bind.annotation.PathVariable Long id,
        Model model) {

    Instructor instructor = instructorService.getInstructorById(id);
    model.addAttribute("instructor", instructor);

    return "instructor-profile";
    
    }

    @PostMapping("/{id}/delete")
    public String deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return "redirect:/instructors";
    }

    
}
