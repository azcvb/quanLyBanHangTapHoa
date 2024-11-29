package com.nhom2IT8.GSMW.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nhom2IT8.GSMW.entity.NhaCungCap;

@Repository
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, String> {
	
	@Query("SELECT s FROM NhaCungCap s")
	List<NhaCungCap> getNCC();

	@Query("SELECT ncc FROM NhaCungCap ncc " + "WHERE (:id IS NULL OR ncc.ncc_id LIKE %:id%) "
			+ "AND (:tenNcc IS NULL OR ncc.ncc_ten LIKE %:tenNcc%) "
			+ "AND (:sdtNcc IS NULL OR ncc.ncc_sdt LIKE %:sdtNcc%) "
			+ "AND (:emailNcc IS NULL OR ncc.ncc_email LIKE %:emailNcc%) "
			+ "AND (:diachiNcc IS NULL OR ncc.ncc_diaChi LIKE %:diachiNcc%)")
	List<NhaCungCap> searchNCC(@Param("id") String id, @Param("tenNcc") String tenNcc, @Param("sdtNcc") String sdtNcc,
			@Param("emailNcc") String emailNcc, @Param("diachiNcc") String diachiNcc);

}
