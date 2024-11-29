package com.nhom2IT8.GSMW.service;

import java.util.List;

import com.nhom2IT8.GSMW.entity.HoaDonBan;
import java.math.BigDecimal;
import java.time.YearMonth;

import java.util.Map;
public interface HoaDonBanService {
    List<HoaDonBan> getAllHoaDonBan();
    HoaDonBan getHoaDonBanById(String id);
    List<HoaDonBan> searchHoaDonBan(String keyword);
    Map<YearMonth, BigDecimal> getTotalByMonth();
    Map<YearMonth, Map<String, BigDecimal>> getEmployeeTotalByMonth();
    long countHoaDonBan();
    BigDecimal sumTotalHoaDonBan();
}
