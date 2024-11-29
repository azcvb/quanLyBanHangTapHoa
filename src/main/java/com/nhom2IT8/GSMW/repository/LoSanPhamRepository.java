package com.nhom2IT8.GSMW.repository;

import com.nhom2IT8.GSMW.entity.LoSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LoSanPhamRepository extends JpaRepository<LoSanPham, String> {
    List<LoSanPham> findByLspTenSanPhamContainingIgnoreCase(String tenSanPham);
    List<LoSanPham> findByLspSpId(String spId);
}
