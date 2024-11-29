package com.nhom2IT8.GSMW.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "giamgia")
public class GiamGia {
    @Id
    @Column(length = 50)
    private String GG_id;

    @Column(length = 50)
    private String GG_SP_id;

    @Column()
    private String GG_tensanpham;

    @Column()
    private Double GG_chietkhau;

    @Column()
    private LocalDate GG_ngaybatdau;

    @Column()
    private LocalDate GG_ngayketthuc;

    @Column()
    private String GG_mota;

    public String getGG_id() {
        return GG_id;
    }

    public void setGG_id(String GG_id) {
        this.GG_id = GG_id;
    }

    public String getGG_SP_id() {
        return GG_SP_id;
    }

    public void setGG_SP_id(String GG_SP_id) {
        this.GG_SP_id = GG_SP_id;
    }

    public String getGG_tensanpham() {
        return GG_tensanpham;
    }

    public void setGG_tensanpham(String GG_tensanpham) {
        this.GG_tensanpham = GG_tensanpham;
    }

    public Double getGG_chietkhau() {
        return GG_chietkhau;
    }

    public void setGG_chietkhau(Double GG_chietkhau) {
        this.GG_chietkhau = GG_chietkhau;
    }

    public LocalDate getGG_ngaybatdau() {
        return GG_ngaybatdau;
    }

    public void setGG_ngaybatdau(LocalDate GG_ngaybatdau) {
        this.GG_ngaybatdau = GG_ngaybatdau;
    }

    public LocalDate getGG_ngayketthuc() {
        return GG_ngayketthuc;
    }

    public void setGG_ngayketthuc(LocalDate GG_ngayketthuc) {
        this.GG_ngayketthuc = GG_ngayketthuc;
    }

    public String getGG_mota() {
        return GG_mota;
    }

    public void setGG_mota(String GG_mota) {
        this.GG_mota = GG_mota;
    }
}
