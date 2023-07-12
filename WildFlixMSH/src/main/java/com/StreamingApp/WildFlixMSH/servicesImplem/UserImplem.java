package com.StreamingApp.WildFlixMSH.servicesImplem;

import com.StreamingApp.WildFlixMSH.enums.RoleName;
import com.StreamingApp.WildFlixMSH.models.Role;
import com.StreamingApp.WildFlixMSH.models.User;
import com.StreamingApp.WildFlixMSH.repositories.RoleRepository;
import com.StreamingApp.WildFlixMSH.repositories.UserRepository;
import com.StreamingApp.WildFlixMSH.services.EmailService;
import com.StreamingApp.WildFlixMSH.services.JwtService;
import com.StreamingApp.WildFlixMSH.services.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
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


//     Garder ca
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    @Override
    public User createUser(User user) {
        String password = user.getPassword();
        String passwordEncoded = this.passwordEncoder.encode(password);
        user.setPassword(passwordEncoded);
        Random random = new Random();
        int code = random.nextInt(1000,10000);
        user.setVerificationEmailCode(code);
        emailService.sendEmail(
                user.getEmail(),
                "Verification de l'adresse email",
                "Voilà le code de vérification de votre email : " +
                        code
        );
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }


    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
    userRepository.deleteById(id);
    }

    @Override
    public void addRoleToUser(String email, RoleName roleName) {
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
            if (user.get().isEmailVerified()){
                authenticationManager
                        .authenticate(
                                new UsernamePasswordAuthenticationToken(
                                        email,
                                        password
                                )
                        );
                return jwtService.generateToken(user.get());
            }
            return "-1";
        }else {
            return null;
        }
    }

    @Override
    public boolean emailConfirmation(String email, int code) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            int codeUser = user.get().getVerificationEmailCode();
            System.out.println(code);
            System.out.println(codeUser);
            if(code == codeUser){
                user.get().setEmailVerified(true);
                return true;
            }

            else
                return false;
        }
        else {
            return false;
        }
    }

}
