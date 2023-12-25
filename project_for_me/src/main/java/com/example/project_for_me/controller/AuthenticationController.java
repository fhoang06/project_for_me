package com.example.project_for_me.controller;

import com.example.project_for_me.dto.JwtAuthenticationResponse;
import com.example.project_for_me.dto.SignUpRequest;
import com.example.project_for_me.dto.SigninRequest;
import com.example.project_for_me.model.NhanVien;
import com.example.project_for_me.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nhanvien/home")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<NhanVien> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/sigin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest){
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }
}
