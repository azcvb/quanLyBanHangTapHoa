package com.nhom2IT8.GSMW.service;

import com.nhom2IT8.GSMW.entity.TaiKhoan;

public interface TaiKhoanService {
    TaiKhoan findByUsernameAndPassword(String username, String password);

    TaiKhoan getById(Integer id);
}
