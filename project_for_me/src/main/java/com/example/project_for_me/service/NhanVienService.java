package com.example.project_for_me.service;

import com.example.project_for_me.model.NhanVien;
import com.example.project_for_me.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NhanVienService implements INhanVien{
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public NhanVien addNhanVien(NhanVien nhanVien) {
        if (nhanVien != null){
            return nhanVienRepository.save(nhanVien);
        }
        return null;
    }

    @Override
    public NhanVien updateNhanVien(long id, NhanVien nhanVien) {
        if (nhanVien != null){
            NhanVien nhanVien1 = nhanVienRepository.getReferenceById(id);
            if (nhanVien1 !=null){
                nhanVien1.setName(nhanVien.getName());
                nhanVien1.setEmail(nhanVien.getEmail());
                nhanVien1.setSecoundname(nhanVien.getSecoundname());

                return nhanVienRepository.save(nhanVien1);
            }
        }
        return null;
    }

    @Override
    public boolean deleteNhanVien(long id) {
        if (id >=1){
            NhanVien nhanVien = nhanVienRepository.getReferenceById(id);
            if (nhanVien != null){
                nhanVienRepository.delete(nhanVien);

                return true;
            }
        }
        return false;
    }

    @Override
    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    @Override
    public NhanVien getOneNhanVien(long id) {
        return nhanVienRepository.getReferenceById(id);
    }
}
