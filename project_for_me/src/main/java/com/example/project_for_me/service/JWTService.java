package com.example.project_for_me.service;

import com.example.project_for_me.model.NhanVien;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;

public interface JWTService {
    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token,UserDetails userDetails);

    String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails);
}
