package com.StreamingApp.WildFlixMSH.servicesImplem;

import com.StreamingApp.WildFlixMSH.enums.RoleName;
import com.StreamingApp.WildFlixMSH.models.Role;
import com.StreamingApp.WildFlixMSH.models.User;
import com.StreamingApp.WildFlixMSH.repositories.RoleRepository;
import com.StreamingApp.WildFlixMSH.repositories.UserRepository;
import com.StreamingApp.WildFlixMSH.services.EmailService;
import com.StreamingApp.WildFlixMSH.services.JwtService;
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
@Transactional
@Service
@RequiredArgsConstructor
public class UserImplem implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    EmailService emailService;
    @Autowired
    JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final
    private final AuthenticationManager authenticationManager;

    @Override
    public User getUserByEmail(String email) {
        return  userRepository.findByEmail(email).orElse(null);
    }


    @Override
    public User createUser(User user) {
        String password = user.getPassword();
        String passwordEncoded = this.passwordEncoder.encode(password);
        user.setPassword(passwordEncoded);
        emailService.sendEmail(
                user.getEmail(),
                "Test",
                "Test"
        );
        return userRepository.save(user);
    }

    @Override
    public void addRoleToUser(String email, RoleName roleName)  {
        Optional<User> user = userRepository.findByEmail(email);
        Optional<Role> role = roleRepository.findByName(roleName);
        if (user.isPresent() && role.isPresent()){
            user.get().getRoles().add(role.get());
        }
    }

    @Override
    public String login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()){

                    .authenticate  (
                            new UsernamePasswordAuthenticationToken(
                                    email,
                                    password
                            )
                    );
            return jwtService.generateToken(user.get());
        }else {
            return null;
        }

    }

    @Override
    public List<User> getAllUser (){
        return userRepository.findAll();
    }
}
