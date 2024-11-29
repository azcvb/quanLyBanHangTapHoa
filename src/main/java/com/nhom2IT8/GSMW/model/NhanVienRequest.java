package com.nhom2IT8.GSMW.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NhanVienRequest {
    private String NV_id;
    private Integer NV_tk_id;
    private String NV_ten;
    private String NV_gioitinh;
    private LocalDate NV_ngaysinh;
    private String NV_sdt;
    private String NV_email;
    private String NV_diachi;
    private BigDecimal NV_luong;
    private String NV_password;

    public String getNV_id() {
        return NV_id;
    }

    public void setNV_id(String NV_id) {
        this.NV_id = NV_id;
    }

    public Integer getNV_tk_id() {
        return NV_tk_id;
    }

    public void setNV_tk_id(Integer NV_tk_id) {
        this.NV_tk_id = NV_tk_id;
    }

    public String getNV_ten() {
        return NV_ten;
    }

    public void setNV_ten(String NV_ten) {
        this.NV_ten = NV_ten;
    }

    public String getNV_gioitinh() {
        return NV_gioitinh;
    }

    public void setNV_gioitinh(String NV_gioitinh) {
        this.NV_gioitinh = NV_gioitinh;
    }

    public LocalDate getNV_ngaysinh() {
        return NV_ngaysinh;
    }

    public void setNV_ngaysinh(LocalDate NV_ngaysinh) {
        this.NV_ngaysinh = NV_ngaysinh;
    }

    public String getNV_sdt() {
        return NV_sdt;
    }

    public void setNV_sdt(String NV_sdt) {
        this.NV_sdt = NV_sdt;
    }

    public String getNV_email() {
        return NV_email;
    }

    public void setNV_email(String NV_email) {
        this.NV_email = NV_email;
    }

    public String getNV_diachi() {
        return NV_diachi;
    }

    public void setNV_diachi(String NV_diachi) {
        this.NV_diachi = NV_diachi;
    }

    public BigDecimal getNV_luong() {
        return NV_luong;
    }

    public void setNV_luong(BigDecimal NV_luong) {
        this.NV_luong = NV_luong;
    }

    public String getNV_password() {
        return NV_password;
    }

    public void setNV_password(String NV_password) {
        this.NV_password = NV_password;
    }
}
