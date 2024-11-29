package com.nhom2IT8.GSMW.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sanpham")
public class SanPham {
	@Id
    @Column(name = "sp_id", length = 50)
    private String SP_id;

    @Column(name = "sp_tensanpham")
    private String SP_TenSanPham;

    @Column(name = "sp_loaisanpham")
    private String SP_LoaiSanPham;

    @Column(name = "sp_giaban")
    private BigDecimal SP_GiaBan;

    @Column(name = "sp_mota")
    private String SP_MoTa;

    @Column(name = "sp_soluong")
    private Integer SP_SoLuong;

    @Column(name = "sp_trangthai")
    private Boolean SP_TrangThai;

    // Constructors, getters, setters (you can generate these with your IDE)

    public SanPham() {
        super();
    }

    public String getSP_id() {
        return SP_id;
    }

    public void setSP_id(String sP_id) {
        SP_id = sP_id;
    }

    public String getSP_TenSanPham() {
        return SP_TenSanPham;
    }

    public void setSP_TenSanPham(String sP_TenSanPham) {
        SP_TenSanPham = sP_TenSanPham;
    }

    public String getSP_LoaiSanPham() {
        return SP_LoaiSanPham;
    }

    public void setSP_LoaiSanPham(String sP_LoaiSanPham) {
        SP_LoaiSanPham = sP_LoaiSanPham;
    }

    public BigDecimal getSP_GiaBan() {
        return SP_GiaBan;
    }

    public void setSP_GiaBan(BigDecimal sP_GiaBan) {
        SP_GiaBan = sP_GiaBan;
    }

    public String getSP_MoTa() {
        return SP_MoTa;
    }

    public void setSP_MoTa(String sP_MoTa) {
        SP_MoTa = sP_MoTa;
    }

    public Integer getSP_SoLuong() {
        return SP_SoLuong;
    }

    public void setSP_SoLuong(Integer sP_SoLuong) {
        SP_SoLuong = sP_SoLuong;
    }

    public Boolean getSP_TrangThai() {
        return SP_TrangThai;
    }

    public void setSP_TrangThai(Boolean sP_TrangThai) {
        SP_TrangThai = sP_TrangThai;
    }
}