package com.StreamingApp.WildFlixMSH.controllers;

import com.StreamingApp.WildFlixMSH.models.User;
import com.StreamingApp.WildFlixMSH.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> getAllUsers (){
        return userService.getAllUser();
    }

    @GetMapping("getUserName")
    public String getName (Authentication authentication){
        return authentication.getName();
    }

    @GetMapping("getRoles")
    public List<String> gettroles (Authentication authentication){
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority grantedAuthority :authentication.getAuthorities()){
            roles.add(grantedAuthority.getAuthority());
        }
        return roles;
    }


}
