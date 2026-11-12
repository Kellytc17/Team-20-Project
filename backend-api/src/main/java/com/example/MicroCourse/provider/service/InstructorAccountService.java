package com.example.MicroCourse.provider.service;

import com.example.MicroCourse.provider.entity.InstructorAccount;
import com.example.MicroCourse.provider.repository.InstructorAccountRepository;

import org.springframework.stereotype.Service;

@Service
public class InstructorAccountService {

    private final InstructorAccountRepository accountRepository;

    public InstructorAccountService(InstructorAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public InstructorAccount createAccount(InstructorAccount account) {
        String email = account.getEmail().trim().toLowerCase();

        if (accountRepository.existsByEmail(email)) {
            throw new RuntimeException("Email is already registered");
        }

        account.setEmail(email);

        return accountRepository.save(account);
    }

    public InstructorAccount getAccountByEmail(String email) {
        return accountRepository.findByEmail(email.trim().toLowerCase())
                .orElseThrow(() -> new RuntimeException("Instructor account not found"));
    }

    public boolean emailExists(String email) {
        return accountRepository.existsByEmail(email.trim().toLowerCase());
    }

}
