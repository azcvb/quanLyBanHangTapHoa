package com.nhom2IT8.GSMW.service;

import com.nhom2IT8.GSMW.entity.HoaDonNhap;

import java.math.BigDecimal;
import java.util.List;

public interface HoaDonNhapService {
    List<HoaDonNhap> getAllHoaDonNhap();
 // Trong HoaDonNhapService.java
    List<HoaDonNhap> searchHoaDonNhap(String keyword);
    
    
    long countHoaDonNhap();
    BigDecimal sumTotalHoaDonNhap();
    
    void saveHoaDonNhap(HoaDonNhap hoaDonNhap);
    
}
