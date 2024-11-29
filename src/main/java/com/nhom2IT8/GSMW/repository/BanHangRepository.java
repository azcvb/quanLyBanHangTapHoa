package com.nhom2IT8.GSMW.repository;

import com.nhom2IT8.GSMW.entity.HoaDonBan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanHangRepository extends JpaRepository<HoaDonBan, String> {
    // Custom query methods can be defined here if needed
}
