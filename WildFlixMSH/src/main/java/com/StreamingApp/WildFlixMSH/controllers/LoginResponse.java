package com.StreamingApp.WildFlixMSH.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private  String jwt;

}
