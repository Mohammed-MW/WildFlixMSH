package com.StreamingApp.WildFlixMSH.controllers;


import com.StreamingApp.WildFlixMSH.enums.RoleName;
import com.StreamingApp.WildFlixMSH.models.User;
import com.StreamingApp.WildFlixMSH.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/auth")
@RestController
public class AuthController {
    @Autowired
    UserService userService;
    @PostMapping("/signup-user")
    public void createUser (@RequestBody User user){
        User result = userService.createUser(user);
        userService.addRoleToUser(result.getEmail(), RoleName.USER);

    }
    @PostMapping("/signup-admin")
    public void createAdmin (@RequestBody User user) {
        User result = userService.createUser(user);
        userService.addRoleToUser(result.getEmail(), RoleName.ADMIN);
    }
    @PostMapping ("/signLn")
    public String login (@RequestBody Map<String, String> request){
        return userService.login(request.get("email"), request.get("password"));
    }
}
