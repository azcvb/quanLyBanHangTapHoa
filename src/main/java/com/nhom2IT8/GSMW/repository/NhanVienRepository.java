package com.nhom2IT8.GSMW.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nhom2IT8.GSMW.entity.NhanVien;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    @Query("select nv from NhanVien nv where " +
            "nv.NV_id LIKE %?1% " +
            "OR CAST(nv.NV_tk_id as string) LIKE %?1% " +
            "OR nv.NV_ten LIKE %?1% " +
            "OR nv.NV_gioitinh LIKE %?1% " +
            "OR nv.NV_sdt LIKE %?1% " +
            "OR nv.NV_email LIKE %?1% " +
            "OR nv.NV_diachi LIKE %?1% " +
            "OR CAST(nv.NV_luong as string) LIKE %?1%")
    List<NhanVien> search(String keyword);
}

