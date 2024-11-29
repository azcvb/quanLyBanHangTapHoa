package com.nhom2IT8.GSMW.repository;

import com.nhom2IT8.GSMW.entity.HoaDonNhap;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonNhapRepository extends JpaRepository<HoaDonNhap, String> {

	@Query("SELECT h FROM HoaDonNhap h WHERE h.hdnId LIKE %:keyword%")
	List<HoaDonNhap> findByKeyword(@Param("keyword") String keyword);

	@Query("SELECT SUM(h.hdnThanhTien) FROM HoaDonNhap h")
	BigDecimal sumTotal();
	boolean existsByHdnLspId(String lspId);
}
