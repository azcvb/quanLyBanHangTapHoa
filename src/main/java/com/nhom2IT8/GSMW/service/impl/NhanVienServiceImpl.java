package com.nhom2IT8.GSMW.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.nhom2IT8.GSMW.entity.TaiKhoan;
import com.nhom2IT8.GSMW.model.NhanVienRequest;
import com.nhom2IT8.GSMW.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nhom2IT8.GSMW.entity.NhanVien;
import com.nhom2IT8.GSMW.repository.NhanVienRepository;
import com.nhom2IT8.GSMW.service.NhanVienService;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    private final TaiKhoanRepository taiKhoanRepository;

    public NhanVienServiceImpl(NhanVienRepository nhanVienRepository,
                               TaiKhoanRepository taiKhoanRepository) {
        this.nhanVienRepository = nhanVienRepository;
        this.taiKhoanRepository = taiKhoanRepository;
    }

    @Override
    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    @Override
    public void createNhanVien(NhanVien nhanVien) {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setTK_ID(nhanVien.getNV_TK_ID());
        taiKhoan.setTK_Username(nhanVien.getNV_Email());
        taiKhoan.setTK_Password("1234");
        taiKhoan.setTK_PhanQuyen("user");
        taiKhoanRepository.save(taiKhoan);
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public NhanVien getNhanVienById(String id) {
        Optional<NhanVien> optional = nhanVienRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void updateNhanVien(NhanVienRequest nhanVien) {
        Optional<NhanVien> existNhanVien = nhanVienRepository.findById(nhanVien.getNV_id());
        existNhanVien.ifPresent(item -> {
            item.setNV_Ten(nhanVien.getNV_ten());
            item.setNV_GioiTinh(nhanVien.getNV_gioitinh());
            if (Objects.nonNull(nhanVien.getNV_ngaysinh())) {
                item.setNV_NgaySinh(nhanVien.getNV_ngaysinh());
            }
            item.setNV_SDT(nhanVien.getNV_sdt());
            item.setNV_DiaChi(nhanVien.getNV_diachi());
            item.setNV_Luong(nhanVien.getNV_luong());
            nhanVienRepository.save(item);
            TaiKhoan taiKhoan = taiKhoanRepository.getById(item.getNV_TK_ID());
            taiKhoan.setTK_Password(nhanVien.getNV_password());
            taiKhoanRepository.save(taiKhoan);
        });
    }

    @Override
    public void deleteNhanVien(String id) {
        NhanVien nhanVien = nhanVienRepository.findById(id).orElse(null);
        TaiKhoan taiKhoan = taiKhoanRepository.findById(nhanVien.getNV_TK_ID()).orElse(null);
        nhanVienRepository.delete(nhanVien);
        taiKhoanRepository.delete(taiKhoan);
    }

    @Override
    public List<NhanVien> search(String keyword) {
        return nhanVienRepository.search(keyword);
    }
}