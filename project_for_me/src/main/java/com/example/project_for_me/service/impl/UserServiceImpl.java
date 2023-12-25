package com.example.project_for_me.service.impl;

import com.example.project_for_me.repository.NhanVienRepository;
import com.example.project_for_me.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final NhanVienRepository nhanVienRepository;

    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return nhanVienRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("user not foud"));
            }
        };
    }
}
