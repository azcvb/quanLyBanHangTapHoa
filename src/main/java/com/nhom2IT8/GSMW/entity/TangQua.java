package com.nhom2IT8.GSMW.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tangqua")
public class TangQua {
    @Id
    @Column(length = 50)
    private String TQ_id;

    @Column(length = 50)
    private String TQ_SP_id;

    @Column()
    private String TQ_tensanpham;

    @Column()
    private Integer TQ_dieukien;

    @Column(length = 50)
    private String TQ_SP_idquatang;

    @Column()
    private Integer TQ_soluongquatang;

    @Column()
    private LocalDate TQ_ngaybatdau;

    @Column()
    private LocalDate TQ_ngayketthuc;

    @Column()
    private String TQ_mota;

    public String getTQ_id() {
        return TQ_id;
    }

    public void setTQ_id(String TQ_id) {
        this.TQ_id = TQ_id;
    }

    public String getTQ_SP_id() {
        return TQ_SP_id;
    }

    public void setTQ_SP_id(String TQ_SP_id) {
        this.TQ_SP_id = TQ_SP_id;
    }

    public String getTQ_tensanpham() {
        return TQ_tensanpham;
    }

    public void setTQ_tensanpham(String TQ_tensanpham) {
        this.TQ_tensanpham = TQ_tensanpham;
    }

    public Integer getTQ_dieukien() {
        return TQ_dieukien;
    }

    public void setTQ_dieukien(Integer TQ_dieukien) {
        this.TQ_dieukien = TQ_dieukien;
    }

    public String getTQ_SP_IDQuaTang() {
        return TQ_SP_idquatang;
    }

    public void setTQ_SP_IDQuaTang(String TQ_SP_idquatang) {
        this.TQ_SP_idquatang = TQ_SP_idquatang;
    }

    public Integer getTQ_soluongquatang() {
        return TQ_soluongquatang;
    }

    public void setTQ_soluongquatang(Integer TQ_soluongquatang) {
        this.TQ_soluongquatang = TQ_soluongquatang;
    }

    public LocalDate getTQ_ngaybatdau() {
        return TQ_ngaybatdau;
    }

    public void setTQ_ngaybatdau(LocalDate TQ_ngaybatdau) {
        this.TQ_ngaybatdau = TQ_ngaybatdau;
    }

    public LocalDate getTQ_ngayketthuc() {
        return TQ_ngayketthuc;
    }

    public void setTQ_ngayketthuc(LocalDate TQ_ngayketthuc) {
        this.TQ_ngayketthuc = TQ_ngayketthuc;
    }

    public String getTQ_mota() {
        return TQ_mota;
    }

    public void setTQ_mota(String TQ_mota) {
        this.TQ_mota = TQ_mota;
    }
}
