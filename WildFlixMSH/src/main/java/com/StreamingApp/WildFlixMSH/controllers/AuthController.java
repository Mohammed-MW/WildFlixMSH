package com.StreamingApp.WildFlixMSH.controllers;
import com.StreamingApp.WildFlixMSH.enums.RoleName;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.StreamingApp.WildFlixMSH.models.User;
import com.StreamingApp.WildFlixMSH.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RequestMapping("/auth")
@RestController
public class AuthController {
    @Autowired
    UserService userService;

    @PostMapping("/sign-up-user")
    void createUser(@RequestBody User user){
        User result = userService. createUser(user);
        userService.addRoleToUser(result.getEmail(), RoleName.USER );
    }

    @PostMapping("/sign-up-admin")
    void createAdmin(@RequestBody User user){
        User result = userService.createUser(user);
        userService.addRoleToUser(result.getEmail(), RoleName.ADMIN);
    }

    @PostMapping("/login")
    String login(@RequestBody Map<String, String> form){
//        return form.get("email") + form.get("password");
        return userService.login(form.get("email"), form.get("password"));
    }
}
