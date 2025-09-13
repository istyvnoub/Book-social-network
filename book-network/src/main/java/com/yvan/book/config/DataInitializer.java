package com.yvan.book.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.yvan.book.role.Role;
import com.yvan.book.role.RoleRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findByName("USER").isEmpty()) {
            roleRepository.save(
                Role.builder()
                    .name("USER")
                    .build()
            );
        }
        
        if (roleRepository.findByName("ADMIN").isEmpty()) {
            roleRepository.save(
                Role.builder()
                    .name("ADMIN")
                    .build()
            );
        }
    }
}
