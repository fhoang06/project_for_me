package com.example.project_for_me.service.impl;

import com.example.project_for_me.dto.JwtAuthenticationResponse;
import com.example.project_for_me.dto.SignUpRequest;
import com.example.project_for_me.dto.SigninRequest;
import com.example.project_for_me.model.NhanVien;
import com.example.project_for_me.model.Role;
import com.example.project_for_me.repository.NhanVienRepository;
import com.example.project_for_me.service.AuthenticationService;
import com.example.project_for_me.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final NhanVienRepository nhanVienRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    public NhanVien signup(SignUpRequest signUpRequest){
        NhanVien nhanVien = new NhanVien();

        nhanVien.setEmail(signUpRequest.getEmail());
        nhanVien.setName(signUpRequest.getFirstName());
        nhanVien.setName(signUpRequest.getLastName());
        nhanVien.setSecoundname(signUpRequest.getFirstName());
        nhanVien.setRole(Role.USER);
        nhanVien.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

       return nhanVienRepository.save(nhanVien);
    }

    public JwtAuthenticationResponse signin(SigninRequest signinRequest){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(),
                signinRequest.getPassword()));

        var nhanvien = nhanVienRepository.findByEmail(signinRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("invalid email or password"));
        var jwt= jwtService.generateToken(nhanvien);
        var refreshToken= jwtService.generateRefreshToken(new HashMap<>(), nhanvien);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        return jwtAuthenticationResponse;
    }
}
