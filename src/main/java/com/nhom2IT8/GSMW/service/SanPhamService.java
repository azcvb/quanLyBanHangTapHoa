package com.nhom2IT8.GSMW.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.nhom2IT8.GSMW.entity.SanPham;

public interface SanPhamService {
	List<SanPham> getSanPhams();

	SanPham saveSanPham(SanPham sanpham);

	SanPham getSanPhamById(String id);

	SanPham updateSanPham(SanPham sanpham);

	void deleteSanPhamById(String id);

	List<SanPham> searchSanPham(String id, String tensanpham, String loaisanpham, BigDecimal giaban, String mota,
			Integer soluong, Boolean trangthai);
	long countSanPham();
    BigDecimal sumTotalSanPham();
    boolean existsById(String id);

	void saveSanPham_T(SanPham sanPham);

	Optional<SanPham> getSanPhamById_T(String id);
}
