package com.nhom2IT8.GSMW.repository;

import com.nhom2IT8.GSMW.entity.GiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiamGiaRepository extends JpaRepository<GiamGia, String> {
    @Query("select gg from GiamGia gg where gg.GG_SP_id = :productId")
    GiamGia findByProductId(String productId);

    @Query("select gg from GiamGia gg where gg.GG_id = :id")
    GiamGia getById(String id);

    @Query("select gg from GiamGia gg where " +
            "gg.GG_id LIKE %?1% " +
            "OR gg.GG_SP_id LIKE %?1% " +
            "OR gg.GG_tensanpham LIKE %?1% " +
            "OR CAST(gg.GG_chietkhau as string) LIKE %?1% " +
            "OR gg.GG_mota LIKE %?1% ")
    List<GiamGia> search(String keyword);

}
