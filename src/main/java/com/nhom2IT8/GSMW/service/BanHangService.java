package com.nhom2IT8.GSMW.service;

import com.nhom2IT8.GSMW.entity.ChiTietHoaDon;
import com.nhom2IT8.GSMW.entity.SanPham;

import java.util.List;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface BanHangService {
	 List<SanPham> getAllSanPham();
	    List<ChiTietHoaDon> getGioHang();
	    void addToCart(String spId, int soLuong);
	    void removeFromCart(int index);
	    void checkout(RedirectAttributes redirectAttributes);
}
