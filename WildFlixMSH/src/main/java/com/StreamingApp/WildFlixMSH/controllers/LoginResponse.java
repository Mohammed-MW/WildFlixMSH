package com.StreamingApp.WildFlixMSH.controllers;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginResponse {
    private  String jwt;
}
