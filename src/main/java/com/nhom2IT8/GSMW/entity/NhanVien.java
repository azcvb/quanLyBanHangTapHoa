package com.nhom2IT8.GSMW.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @Column(length = 50)
    private String NV_id;

    @Column(nullable = false, unique = true)
    private Integer NV_tk_id;

    @Column(nullable = false)
    private String NV_ten;

    @Column(nullable = false)
    private String NV_gioitinh;

    @Column(nullable = false)
    private LocalDate NV_ngaysinh;

    @Column(nullable = false, unique = true)
    private String NV_sdt;

    @Column(nullable = false, unique = true)
    private String NV_email;

    @Column(nullable = false)
    private String NV_diachi;

    @Column(nullable = false)
    private BigDecimal NV_luong;
    
    
    // Getters and Setters
    public String getNV_ID() {
        return NV_id;
    }

    public void setNV_ID(String NV_ID) {
        this.NV_id = NV_ID;
    }

    public Integer getNV_TK_ID() {
        return NV_tk_id;
    }

    public void setNV_TK_ID(Integer NV_TK_ID) {
        this.NV_tk_id = NV_TK_ID;
    }

    public String getNV_Ten() {
        return NV_ten;
    }

    public void setNV_Ten(String NV_Ten) {
        this.NV_ten = NV_Ten;
    }

    public String getNV_GioiTinh() {
        return NV_gioitinh;
    }

    public void setNV_GioiTinh(String NV_GioiTinh) {
        this.NV_gioitinh = NV_GioiTinh;
    }

    public LocalDate getNV_NgaySinh() {
        return NV_ngaysinh;
    }

    public void setNV_NgaySinh(LocalDate NV_NgaySinh) {
        this.NV_ngaysinh = NV_NgaySinh;
    }

    public String getNV_SDT() {
        return NV_sdt;
    }

    public void setNV_SDT(String NV_SDT) {
        this.NV_sdt = NV_SDT;
    }

    public String getNV_Email() {
        return NV_email;
    }

    public void setNV_Email(String NV_Email) {
        this.NV_email = NV_Email;
    }

    public String getNV_DiaChi() {
        return NV_diachi;
    }

    public void setNV_DiaChi(String NV_DiaChi) {
        this.NV_diachi = NV_DiaChi;
    }

    public BigDecimal getNV_Luong() {
        return NV_luong;
    }

    public void setNV_Luong(BigDecimal NV_Luong) {
        this.NV_luong = NV_Luong;
    }
}
