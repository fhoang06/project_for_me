package com.example.project_for_me.repository;

import com.example.project_for_me.model.NhanVien;
import com.example.project_for_me.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {

    Optional<NhanVien> findByEmail(String email);

    NhanVien findByRole(Role role);
}
