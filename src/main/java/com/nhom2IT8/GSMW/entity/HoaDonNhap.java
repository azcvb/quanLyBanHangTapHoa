package com.nhom2IT8.GSMW.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "hoadonnhap")
public class HoaDonNhap {

    @Id
    @GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "hdn_id", columnDefinition = "VARCHAR(50)")
    private String hdnId;

    @Column(name = "hdn_lsp_id", length=50)
    private String hdnLspId;

    @Column(nullable = false, name = "hdn_dongia", precision = 19, scale = 2)
    private BigDecimal hdnDonGia;

    @Column(nullable = false, name = "hdn_soluong")
    private Integer hdnSoLuong;

    @Column(nullable = false, name = "hdn_thanhtien", precision = 19, scale = 2)
    private BigDecimal hdnThanhTien;

    @Column(nullable = false, name = "hdn_ngayxuathoadon")
    private LocalDateTime hdnNgayXuatHoaDon;

    // Getters and Setters
    // Getters and Setters

    public String getHdnId() {
        return hdnId;
    }

    public void setHdnId(String hdnId) {
        this.hdnId = hdnId;
    }

    public String getHdnLspId() {
    	return hdnLspId;
    }

    public void setHdnLspId(String hdnLspId) {
        this.hdnLspId = hdnLspId;
    }

    public BigDecimal getHdnDonGia() {
        return hdnDonGia;
    }

    public void setHdnDonGia(BigDecimal hdnDonGia) {
        this.hdnDonGia = hdnDonGia;
    }

    public Integer getHdnSoLuong() {
        return hdnSoLuong;
    }

    public void setHdnSoLuong(Integer hdnSoLuong) {
        this.hdnSoLuong = hdnSoLuong;
    }

    public BigDecimal getHdnThanhTien() {
        return hdnThanhTien;
    }

    public void setHdnThanhTien(BigDecimal hdnThanhTien) {
        this.hdnThanhTien = hdnThanhTien;
    }

    public LocalDateTime getHdnNgayXuatHoaDon() {
        return hdnNgayXuatHoaDon;
    }

    public void setHdnNgayXuatHoaDon(LocalDateTime hdnNgayXuatHoaDon) {
        this.hdnNgayXuatHoaDon = hdnNgayXuatHoaDon;
    }
}