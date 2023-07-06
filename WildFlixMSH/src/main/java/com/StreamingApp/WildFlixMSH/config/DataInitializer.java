package com.StreamingApp.WildFlixMSH.config;

import com.StreamingApp.WildFlixMSH.enums.RoleName;
import com.StreamingApp.WildFlixMSH.models.Role;
import com.StreamingApp.WildFlixMSH.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;

public class DataInitializer implements CommandLineRunner {
    private final RoleRepository roleRepo;

    public DataInitializer(RoleRepository roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        for (RoleName role : RoleName.values()) {
            roleRepo.save(new Role(null, role));
        }
    }
}
