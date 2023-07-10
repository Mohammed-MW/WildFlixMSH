package com.StreamingApp.WildFlixMSH.services;

import com.StreamingApp.WildFlixMSH.enums.RoleName;
import com.StreamingApp.WildFlixMSH.models.User;


import java.util.List;
public interface UserService {

    User getUserByEmail (String email);
    User createUser (User user) ;
    void addRoleToUser (String email, RoleName roleName) ;

    String login (String email, String password);
    List<User> getAllUser();
}