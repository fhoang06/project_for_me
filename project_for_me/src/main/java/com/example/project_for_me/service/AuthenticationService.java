package com.example.project_for_me.service;

import com.example.project_for_me.dto.JwtAuthenticationResponse;
import com.example.project_for_me.dto.SignUpRequest;
import com.example.project_for_me.dto.SigninRequest;
import com.example.project_for_me.model.NhanVien;

public interface AuthenticationService {
    NhanVien signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SigninRequest signinRequest);
}
