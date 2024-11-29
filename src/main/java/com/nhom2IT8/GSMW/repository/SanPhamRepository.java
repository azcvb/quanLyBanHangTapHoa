package com.nhom2IT8.GSMW.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nhom2IT8.GSMW.entity.SanPham;

import jakarta.transaction.Transactional;

public interface SanPhamRepository  extends JpaRepository<SanPham, String> {
	
	@Query("SELECT s FROM SanPham s")
	List<SanPham> GetSanPhams();

	@Query("SELECT sp FROM SanPham sp " + "WHERE (:id IS NULL OR sp.SP_id LIKE %:id%) "
			+ "AND (:tenSanPham IS NULL OR sp.SP_TenSanPham LIKE %:tenSanPham%) "
			+ "AND (COALESCE(:loaiSanPham, '') = '' OR sp.SP_LoaiSanPham = :loaiSanPham)" 
			+ "AND (COALESCE(:giaBan, '') = '' OR sp.SP_GiaBan = :giaBan)"
			+ "AND (:moTa IS NULL OR sp.SP_MoTa LIKE %:moTa%) "
			+ "AND (COALESCE(:soLuong, '') = '' OR sp.SP_SoLuong = :soLuong)"
			+ "AND (COALESCE(:trangThai, '') = '' OR sp.SP_TrangThai = :trangThai)")
	List<SanPham> findByCriteria(@Param("id") String id, @Param("tenSanPham") String tenSanPham,
			@Param("loaiSanPham") String loaiSanPham, @Param("giaBan") BigDecimal giaBan, @Param("moTa") String moTa,
			@Param("soLuong") Integer soLuong, @Param("trangThai") Boolean trangThai);
	
	@Query("SELECT SUM(sp.SP_SoLuong) FROM SanPham sp")
    BigDecimal sumTotalQuantity();
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO SanPham (SP_TenSanPham, SP_LoaiSanPham, SP_GiaBan, SP_MoTa, SP_SoLuong, SP_TrangThai) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
	void insertSanPham(String SP_TenSanPham, String SP_LoaiSanPham, BigDecimal SP_GiaBan, String SP_MoTa,
			int SP_SoLuong, boolean SP_TrangThai);

	@Query("SELECT sp FROM SanPham sp WHERE sp.SP_TenSanPham = :TenSanPham")
	Optional<SanPham> findTen(@Param("TenSanPham") String TenSanPham);
    @Modifying
    @Query("UPDATE SanPham sp SET sp.SP_TenSanPham = :name, sp.SP_LoaiSanPham = :category, sp.SP_GiaBan = :price, sp.SP_MoTa = :description, sp.SP_SoLuong = :quantity WHERE sp.SP_id = :id")
    int update(@Param("id") String id,
                      @Param("name") String name,
                      @Param("category") String category,
                      @Param("price") BigDecimal price,
                      @Param("description") String description,
                      @Param("quantity") int quantity);
}
