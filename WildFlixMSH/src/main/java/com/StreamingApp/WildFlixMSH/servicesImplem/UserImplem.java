package com.StreamingApp.WildFlixMSH.servicesImplem;

import com.StreamingApp.WildFlixMSH.enums.RoleName;
import com.StreamingApp.WildFlixMSH.models.Role;
import com.StreamingApp.WildFlixMSH.models.User;
import com.StreamingApp.WildFlixMSH.repositories.RoleRepository;
import com.StreamingApp.WildFlixMSH.repositories.UserRepository;
import com.StreamingApp.WildFlixMSH.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserImplem implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public User createUser(User user) {
        String password = user.getPassword();
        String passwordEncoded = passwordEncoder.encode(password);
        user.setPassword(passwordEncoded);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void addRoleToUser(String email, RoleName roleName) {
        Optional<Role> role = roleRepository.findByName(roleName);
        Optional<User> user = userRepository.findByEmail(email);

        if (role.isPresent() && user.isPresent()){
            user.get().getRoles().add(role.get());
        }
    }

    @Override
    public String login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()){
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            email,
                            password
                    )
            );
        }
        return "user not found";
    }
}
