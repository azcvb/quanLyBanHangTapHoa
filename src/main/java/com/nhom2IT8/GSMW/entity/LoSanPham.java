package com.nhom2IT8.GSMW.entity;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "losanpham")
public class LoSanPham {

	@Id
    @GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "lsp_id", columnDefinition = "VARCHAR(50)")
    private String lspId;
    
    @Column(name = "lsp_sp_id", length=50)
    private String lspSpId;

    @Column(name = "lsp_ncc_id", length=50)
    private String lspNccId;
    
    @Column(nullable = false, name = "lsp_tensanpham")
    private String lspTenSanPham;
    
    @Column(nullable = false, name = "lsp_loaisanpham")
    private String lspLoaiSanPham;
    
    @Column(nullable = false, name = "lsp_ngaynhap")
    private LocalDateTime lspNgayNhap;
    
    @Column(nullable = false, name = "lsp_dongia", precision = 19, scale = 2)
    private BigDecimal lspDonGia;
    
    @Column(nullable = false, name = "lsp_soluong")
    private Integer lspSoLuong;
    
    @Column(nullable = false, name = "lsp_thanhtien", precision = 19, scale = 2)
    private BigDecimal lspThanhTien;
    
    @Column(nullable = false, name = "lsp_giabanle", precision = 19, scale = 2)
    private BigDecimal lspGiaBanLe;
    
    @Column(nullable = false, name = "lsp_mota")
    private String lspMoTa;

    // Getters and Setters
    public String getLspId() {
        return lspId;
    }

    public void setLspId(String lspId) {
        this.lspId = lspId;
    }

    public String getLspSpId() {
        return lspSpId;
    }

    public void setLspSpId(String lspSpId) {
        this.lspSpId = lspSpId;
    }
    
    public String getLspNccId() {
        return lspNccId;
    }

    public void setLspNccId(String lspNccId) {
        this.lspNccId = lspNccId;
    }
    
    public String getLspTenSanPham() {
        return lspTenSanPham;
    }

    public void setLspTenSanPham(String lspTenSanPham) {
        this.lspTenSanPham = lspTenSanPham;
    }

    public String getLspLoaiSanPham() {
        return lspLoaiSanPham;
    }

    public void setLspLoaiSanPham(String lspLoaiSanPham) {
        this.lspLoaiSanPham = lspLoaiSanPham;
    }

    public LocalDateTime getLspNgayNhap() {
        return lspNgayNhap;
    }

    public void setLspNgayNhap(LocalDateTime lspNgayNhap) {
        this.lspNgayNhap = lspNgayNhap;
    }

    public BigDecimal getLspDonGia() {
        return lspDonGia;
    }

    public void setLspDonGia(BigDecimal lspDonGia) {
        this.lspDonGia = lspDonGia;
    }

    public Integer getLspSoLuong() {
        return lspSoLuong;
    }

    public void setLspSoLuong(Integer lspSoLuong) {
        this.lspSoLuong = lspSoLuong;
    }

    public BigDecimal getLspThanhTien() {
        return lspThanhTien;
    }

    public void setLspThanhTien(BigDecimal lspThanhTien) {
        this.lspThanhTien = lspThanhTien;
    }

    public BigDecimal getLspGiaBanLe() {
        return lspGiaBanLe;
    }

    public void setLspGiaBanLe(BigDecimal lspGiaBanLe) {
        this.lspGiaBanLe = lspGiaBanLe;
    }

    public String getLspMoTa() {
        return lspMoTa;
    }

    public void setLspMoTa(String lspMoTa) {
        this.lspMoTa = lspMoTa;
    }
}
