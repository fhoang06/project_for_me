package com.example.project_for_me.controller;

import com.example.project_for_me.model.NhanVien;
import com.example.project_for_me.service.INhanVien;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nhanvien/user")
@RequiredArgsConstructor
public class NhanVienController {
    @Autowired
    private INhanVien iNhanVien;

    @GetMapping("/")
    public String test(){
        return "nguyen duc hoang";
    }

    @PostMapping("/add")
    public NhanVien addNhanVien(@RequestBody NhanVien nhanVien){
        return iNhanVien.addNhanVien(nhanVien);
    }

    @PutMapping("/update")
    public NhanVien updateNhanVien(@RequestParam("id") long id, @RequestBody NhanVien nhanVien){
        return iNhanVien.updateNhanVien(id, nhanVien);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteNhanVien(@PathVariable("id") long id){
        return iNhanVien.deleteNhanVien(id);
    }

    @GetMapping("/list")
    public List<NhanVien> getAllNhanVien(){
        return iNhanVien.getAllNhanVien();
    }
}
