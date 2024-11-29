package com.nhom2IT8.GSMW.service;

import java.util.List;

import com.nhom2IT8.GSMW.entity.NhanVien;
import com.nhom2IT8.GSMW.model.NhanVienRequest;

public interface NhanVienService {
    List<NhanVien> getAllNhanVien();
    void createNhanVien(NhanVien nhanVien);
    NhanVien getNhanVienById(String id);
    void deleteNhanVien(String id);
    void updateNhanVien(NhanVienRequest nhanVien);
    List<NhanVien> search(String keyword);

}
