package com.nhom2IT8.GSMW.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "taikhoan")
public class TaiKhoan {

    @Id
    @Column(nullable = false, name = "tk_id")
    private int id;

    @Column(nullable = false, name = "tk_username")
    private String username;

    @Column(nullable = false, name = "tk_password")
    private String password;

    @Column(nullable = false, name = "tk_phanquyen")
    private String phanQuyen;

    public int getTK_ID() {
        return id;
    }

    public void setTK_ID(int TK_ID) {
        this.id = TK_ID;
    }

    public String getTK_Username() {
        return username;
    }

    public void setTK_Username(String TK_Username) {
        this.username = TK_Username;
    }

    public String getTK_Password() {
        return password;
    }

    public void setTK_Password(String TK_Password) {
        this.password = TK_Password;
    }

    public String getTK_PhanQuyen() {
        return phanQuyen;
    }

    public void setTK_PhanQuyen(String TK_PhanQuyen) {
        this.phanQuyen = TK_PhanQuyen;
    }
}
