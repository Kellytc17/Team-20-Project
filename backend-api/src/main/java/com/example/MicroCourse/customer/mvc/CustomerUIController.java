package com.example.MicroCourse.customer.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.example.MicroCourse.customer.entity.Customer;
import com.example.MicroCourse.customer.service.CustomerService;

@Controller 
@RequestMapping("/customers")
public class CustomerUIController {
    private final CustomerService service; 

    public CustomerUIController(CustomerService service){
        this.service = service;
         System.out.println("CustomerUIController loaded");
    }


    @GetMapping("/register")
    public String registerForm(Model model){

        model.addAttribute("customer", new Customer());
        return "CustomerTemplates/CustomerRegister";
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute Customer customer){
        Customer savedCustomer = service.registerCustomer(customer);
        return "redirect:/customers/profile/" + savedCustomer.getId();
    }
    
    
    @GetMapping("/profile/{id}")
    public String profile(@PathVariable Long id, Model model) {
        model.addAttribute("customer", service.getCustomer(id));
        return "CustomerTemplates/CustomerProfile";
    }

    @GetMapping("/edit-details/{id}")
    public String editDetails(@PathVariable Long id, Model model) {
        model.addAttribute("customer", service.getCustomer(id));
        return "customer/edit-details";
    }

    @PostMapping("/edit-details/{id}")
    public String updateDetails(@PathVariable Long id, @ModelAttribute Customer customer) {
        service.updateProfile(id, customer);

        return "redirect:/customers/profile/" + id;
    }

}
