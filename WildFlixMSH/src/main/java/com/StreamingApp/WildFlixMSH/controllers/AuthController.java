package com.StreamingApp.WildFlixMSH.controllers;


import com.StreamingApp.WildFlixMSH.enums.RoleName;
import com.StreamingApp.WildFlixMSH.models.User;
import com.StreamingApp.WildFlixMSH.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/auth")
@RestController
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    //    12/07 Email verification branch
    @PostMapping("/sign-up-user")
    void createUser(@RequestBody User user){
        User result = userService.createUser(user);
        userService.addRoleToUser(result.getEmail(), RoleName.USER);
    }

    @PostMapping("/sign-up-admin")
    void createAdmin(@RequestBody User user){
        User result = userService.createUser(user);
        userService.addRoleToUser(result.getEmail(), RoleName.ADMIN);
    }
    @PostMapping("/login")
    ResponseEntity<String> login (@RequestBody Map<String, String> form){
        String response = userService.login(form.get("email"), form.get("password"));
        if (response == null) {
            return new ResponseEntity<>(
                    "Email ou le mot de passe sont incorrects",
                    HttpStatus.UNAUTHORIZED
            );
        }else
        if (response.equals("" +
                "")){
            return new ResponseEntity<>(
                    "Vous n'avez pas encore vérifié votre email",
                    HttpStatus.UNAUTHORIZED
            );
        }else{
            return new ResponseEntity<>(
                    response,
                    HttpStatus.OK
            );
        }

    }
    @PostMapping("email-confirmation/{email}")
    boolean emailConfirmation(@PathVariable  String email, @RequestBody Map<String, Integer> request){
        return userService.emailConfirmation(email, request.get("code"));
    }



}



 /*   @PostMapping("/signup-user")
    public void createUser (@RequestBody User user){
        User result = userService.createUser(user);
        userService.addRoleToUser(result.getEmail(), RoleName.USER);

    }
    @PostMapping("/signup-admin")
    public void createAdmin (@RequestBody User user) {
        User result = userService.createUser(user);
        userService.addRoleToUser(result.getEmail(), RoleName.ADMIN);
    }*/