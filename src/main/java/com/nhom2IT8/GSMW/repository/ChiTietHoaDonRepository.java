package com.nhom2IT8.GSMW.repository;

import com.nhom2IT8.GSMW.entity.ChiTietHoaDon;

import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon, Integer> {
	
	@Modifying
    @Transactional
    @Query(value = "INSERT INTO chitiethoadon (cthd_hd_id, cthd_sp_id, cthd_dongia, cthd_soluong, cthd_thanhtien) " +
            "VALUES (:hdbId, :spId, :donGia, :soLuong, :thanhTien)",
            nativeQuery = true)
    void insertChiTietHoaDon(@Param("hdbId") String hdbId,
                             @Param("spId") String spId,
                             @Param("donGia") BigDecimal donGia,
                             @Param("soLuong") int soLuong,
                             @Param("thanhTien") BigDecimal thanhTien);
                             
	@Query("SELECT ct.sanPham.SP_TenSanPham, SUM(ct.cthdSoLuong) as total FROM ChiTietHoaDon ct GROUP BY ct.sanPham.SP_TenSanPham")
    List<Object[]> getSanPhamStatistics();
}
