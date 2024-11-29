package com.nhom2IT8.GSMW.service;

import com.nhom2IT8.GSMW.entity.GiamGia;

import java.util.List;

public interface GiamGiaService {
    List<GiamGia> getAll();
    void createOrUpdate(GiamGia giamGia);
    GiamGia getById(String id);
    List<GiamGia> search(String keyword);
}
