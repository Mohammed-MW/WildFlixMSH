package com.StreamingApp.WildFlixMSH.DTOs;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDTO {
    String email;
    List<String> roles;
}
