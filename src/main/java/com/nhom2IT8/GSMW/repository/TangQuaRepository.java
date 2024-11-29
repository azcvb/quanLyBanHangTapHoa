package com.nhom2IT8.GSMW.repository;

import com.nhom2IT8.GSMW.entity.TangQua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TangQuaRepository extends JpaRepository<TangQua, String> {
    @Query("select tq from TangQua tq where tq.TQ_id = :id")
    TangQua getById(String id);

    @Query("select tq from TangQua tq where " +
            "tq.TQ_id LIKE %?1% " +
            "OR tq.TQ_SP_id LIKE %?1% " +
            "OR tq.TQ_tensanpham LIKE %?1% " +
            "OR CAST(tq.TQ_dieukien as string) LIKE %?1% " +
            "OR tq.TQ_SP_idquatang LIKE %?1% " +
            "OR CAST(tq.TQ_soluongquatang as string) LIKE %?1% " +
            "OR tq.TQ_mota LIKE %?1%")
    List<TangQua> search(String keyword);
}
