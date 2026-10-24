package com.example.MicroCourse.customer.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.MicroCourse.customer.entity.Customer;
import com.example.MicroCourse.customer.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

  //register new account 
    public Customer registerCustomer(Customer customer) {

        if (customerRepository.existsByEmailIgnoreCase(customer.getEmail())) {
            throw new RuntimeException("An account with that email already exists.");
        }

        if (customerRepository.existsByUserNameIgnoreCase(customer.getUserName())) {
            throw new RuntimeException("That username is already taken.");
        }

        return customerRepository.save(customer);
    }

    //login using email 
    public Customer loginByEmail(String email, String password) {

        Customer customer = customerRepository
                .findByEmailIgnoreCase(email)
                .orElseThrow(() ->
                        new RuntimeException("No account found with that email."));

        if (!customer.getPassword().equals(password)) {
            throw new RuntimeException("Incorrect password.");
        }

        return customer;
    }

    //Login using username 
    public Customer loginByUserName(String userName, String password) {

        Customer customer = customerRepository
                .findByUserNameIgnoreCase(userName)
                .orElseThrow(() ->
                        new RuntimeException("No account found with that username."));

        if (!customer.getPassword().equals(password)) {
            throw new RuntimeException("Incorrect password.");
        }

        return customer;
    }

  //Search customer by email
    public Customer findByEmail(String email) {

        return customerRepository
                .findByEmailIgnoreCase(email)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found."));
    }

  //Search customer by name 
    public Customer findByUserName(String userName) {

        return customerRepository
                .findByUserNameIgnoreCase(userName)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found."));
    }

   //get customer id 
    public Customer getCustomer(Long id) {

        return customerRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found."));
    }

    //Update customer profile 
    public Customer updateProfile(Long id, Customer updatedCustomer) {

        Customer customer = getCustomer(id);

        customer.setFirstName(updatedCustomer.getFirstName());
        customer.setLastName(updatedCustomer.getLastName());
        customer.setEmail(updatedCustomer.getEmail());
        customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
        customer.setInterests(updatedCustomer.getInterests());

        return customerRepository.save(customer);
    }

//Delete customer account
    public void deleteCustomer(Long id) {

        Customer customer = getCustomer(id);

        customerRepository.delete(customer);
    }
}
