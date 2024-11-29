package com.nhom2IT8.GSMW.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nhom2IT8.GSMW.entity.HoaDonBan;

public interface HoaDonBanRepository extends JpaRepository<HoaDonBan, String> {

    @Query("SELECT h FROM HoaDonBan h WHERE h.hdbId LIKE %:keyword%")
    List<HoaDonBan> searchByKeyword(@Param("keyword") String keyword);

    @Query("SELECT YEAR(h.hdbNgayXuat), MONTH(h.hdbNgayXuat), SUM(h.hdbTongTien) " +
            "FROM HoaDonBan h " +
            "GROUP BY YEAR(h.hdbNgayXuat), MONTH(h.hdbNgayXuat)")
     List<Object[]> findTotalByMonth();
     @Query("SELECT h.hdbNvId, YEAR(h.hdbNgayXuat), MONTH(h.hdbNgayXuat), SUM(h.hdbTongTien) " +
    	       "FROM HoaDonBan h " +
    	       "GROUP BY h.hdbNvId, YEAR(h.hdbNgayXuat), MONTH(h.hdbNgayXuat)")
    	List<Object[]> findTotalByEmployeeAndMonth();
    @Query("SELECT SUM(h.hdbTongTien) FROM HoaDonBan h")
    BigDecimal sumTotal();
    
    @Query(value = "SELECT h.hdbId FROM HoaDonBan h ORDER BY h.hdbNgayXuat DESC LIMIT 1")
    String findLatestHdbId();
}
