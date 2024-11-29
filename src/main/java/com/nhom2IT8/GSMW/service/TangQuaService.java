package com.nhom2IT8.GSMW.service;

import com.nhom2IT8.GSMW.entity.TangQua;

import java.util.List;

public interface TangQuaService {
    List<TangQua> getAll();
    void save(TangQua tangQua);
    TangQua getById(String id);
    void update(TangQua tangQua);
    void delete(String id);
    List<TangQua> search(String keyword);
}
