package com.StreamingApp.WildFlixMSH.config;

import com.StreamingApp.WildFlixMSH.enums.RoleName;
import com.StreamingApp.WildFlixMSH.models.Role;
import com.StreamingApp.WildFlixMSH.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final RoleRepository  roleRepo;
    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepo = roleRepository;
    }
    @Override
    public void run(String... args) {
        for (RoleName role : RoleName.values()) {
            roleRepo.save(new Role(null, role));
        }
    }
}
