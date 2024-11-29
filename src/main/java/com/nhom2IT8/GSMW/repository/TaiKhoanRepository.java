package com.nhom2IT8.GSMW.repository;

import com.nhom2IT8.GSMW.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {
    TaiKhoan findByUsernameAndPassword(String username, String password);

    TaiKhoan getById(Integer id);
}
