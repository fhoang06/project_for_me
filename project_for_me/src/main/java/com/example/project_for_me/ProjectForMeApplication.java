package com.example.project_for_me;

import com.example.project_for_me.model.NhanVien;
import com.example.project_for_me.model.Role;
import com.example.project_for_me.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ProjectForMeApplication implements CommandLineRunner {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjectForMeApplication.class, args);
    }

    public void run(String...args){
        NhanVien adminAccount = nhanVienRepository.findByRole(Role.ADMIN);
        if (null == adminAccount){
            NhanVien nhanVien = new NhanVien();

            nhanVien.setEmail("admin@gmail.com");
            nhanVien.setName("admin");
            nhanVien.setSecoundname("admin");
            nhanVien.setRole(Role.ADMIN);
            nhanVien.setPassword(new BCryptPasswordEncoder().encode("admin"));
            nhanVienRepository.save(nhanVien);
        }
    }
}
