package com.example.project_for_me.dto;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {

    private String token;
    private String refreshToken;
}
