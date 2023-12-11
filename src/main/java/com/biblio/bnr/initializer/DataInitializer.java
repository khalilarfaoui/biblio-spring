package com.biblio.bnr.initializer;

import com.biblio.bnr.entity.Role;
import com.biblio.bnr.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
    }
}
