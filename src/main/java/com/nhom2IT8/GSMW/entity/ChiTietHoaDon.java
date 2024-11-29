package com.nhom2IT8.GSMW.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "chitiethoadon")
public class ChiTietHoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cthd_id")
    private Integer cthdId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cthd_hd_id") // 
    private HoaDonBan hoaDonBan;

    @ManyToOne
    @JoinColumn(name = "cthd_sp_id")
    private SanPham sanPham;

    @Column(name = "cthd_dongia", precision = 19, scale = 2)
    private BigDecimal cthdDonGia;

    @Column(name = "cthd_soluong")
    private int cthdSoLuong;

    @Column(name = "cthd_thanhtien", precision = 19, scale = 2)
    private BigDecimal cthdThanhTien;

    // Getters and Setters
    public Integer getCthdId() {
        return cthdId;
    }

    public void setCthdId(Integer cthdId) {
        this.cthdId = cthdId;
    }

    public HoaDonBan getHoaDonBan() {
        return hoaDonBan;
    }

    public void setHoaDonBan(HoaDonBan hoaDonBan) {
        this.hoaDonBan = hoaDonBan;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public BigDecimal getCthdDonGia() {
        return cthdDonGia;
    }

    public void setCthdDonGia(BigDecimal cthdDonGia) {
        this.cthdDonGia = cthdDonGia;
    }

    public int getCthdSoLuong() {
        return cthdSoLuong;
    }

    public void setCthdSoLuong(int cthdSoLuong) {
        this.cthdSoLuong = cthdSoLuong;
    }

    public BigDecimal getCthdThanhTien() {
        return cthdThanhTien;
    }

    public void setCthdThanhTien(BigDecimal cthdThanhTien) {
        this.cthdThanhTien = cthdThanhTien;
    }
    
    
    public String getSpId() {
        return sanPham.getSP_id(); 
    }
    
}
