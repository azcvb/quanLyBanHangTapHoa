package com.nhom2IT8.GSMW.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "hoadonban")
public class HoaDonBan {
	
	@Id
    @GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "hdb_id", length=50)
    private String hdbId;

    @Column(name = "hdb_nv_id", length=50)
    private String hdbNvId;
    
    @Column(name = "hdb_ngayxuat")
    private LocalDateTime hdbNgayXuat;
    
    @Column(name="hdb_tongtien", precision = 19, scale = 2)
    private BigDecimal hdbTongTien;
    
    
    @OneToMany(mappedBy = "hoaDonBan", cascade = CascadeType.ALL)
    private List<ChiTietHoaDon> chiTietHoaDons;
    // Getters and Setters
    public String getHdbId() {
        return hdbId;
    }

    public void setHdbId(String hdbId) {
        this.hdbId = hdbId;
    }

    public String getHdbNvId() {
    	return hdbNvId;
    }
    public void setHdbNvId(String hdbNvId) {
    	this.hdbNvId = hdbNvId;
    }
    
    public LocalDateTime getHdbNgayXuat() {
        return hdbNgayXuat;
    }

    public void setHdbNgayXuat(LocalDateTime hdbNgayXuat) {
        this.hdbNgayXuat = hdbNgayXuat;
    }
    
    public BigDecimal getHdbTongTien() {
        return hdbTongTien;
    }

    public void setHdbTongTien(BigDecimal hdbTongTien) {
        this.hdbTongTien = hdbTongTien;
    }

    public List<ChiTietHoaDon> getChiTietHoaDons() {
        return chiTietHoaDons;
    }

    public void setChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {
        this.chiTietHoaDons = chiTietHoaDons;
    }
}