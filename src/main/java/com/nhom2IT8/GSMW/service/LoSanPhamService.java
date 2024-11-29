package com.nhom2IT8.GSMW.service;

import com.nhom2IT8.GSMW.entity.HoaDonNhap;
import com.nhom2IT8.GSMW.entity.LoSanPham;
import java.util.List;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface LoSanPhamService {
    List<LoSanPham> getAllLoSanPham();
    LoSanPham getLoSanPhamById(String id);
    void saveLoSanPham(LoSanPham loSanPham, RedirectAttributes redirectAttributes);
    void deleteLoSanPhamById(String id, RedirectAttributes redirectAttributes);
    List<LoSanPham> searchLoSanPham(String keyword);
    void exportInvoice(HoaDonNhap hoaDonNhap);
    void updateLoSanPham(LoSanPham loSanPham, RedirectAttributes redirectAttributes);
    
}