package com.StreamingApp.WildFlixMSH.controllers;


import com.StreamingApp.WildFlixMSH.models.User;
import com.StreamingApp.WildFlixMSH.services.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return authentication.name();
    }

}
