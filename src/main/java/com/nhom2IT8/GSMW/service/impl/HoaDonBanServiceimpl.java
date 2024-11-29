package com.nhom2IT8.GSMW.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom2IT8.GSMW.entity.HoaDonBan;
import com.nhom2IT8.GSMW.repository.HoaDonBanRepository;
import com.nhom2IT8.GSMW.service.HoaDonBanService;
import java.math.BigDecimal;
import java.time.Year;
import java.time.YearMonth;

import java.util.Map;

@Service
public class HoaDonBanServiceimpl implements HoaDonBanService {

	@Autowired
	private HoaDonBanRepository hoaDonBanRepository;

	@Override
	public List<HoaDonBan> getAllHoaDonBan() {
		return hoaDonBanRepository.findAll();
	}

	@Override
	public HoaDonBan getHoaDonBanById(String id) {
		return hoaDonBanRepository.findById(id).orElse(null);
	}

	@Override
	public List<HoaDonBan> searchHoaDonBan(String keyword) {
		return hoaDonBanRepository.searchByKeyword(keyword);
	}

	@Override
	public Map<YearMonth, BigDecimal> getTotalByMonth() {
		List<Object[]> results = hoaDonBanRepository.findTotalByMonth();
		Map<YearMonth, BigDecimal> revenueByMonth = new HashMap<>();

		for (int month = 1; month <= 12; month++) {
			YearMonth yearMonth = YearMonth.of(Year.now().getValue(), month);
			revenueByMonth.put(yearMonth, BigDecimal.ZERO);
		}

		for (Object[] result : results) {
			YearMonth month = YearMonth.of((Integer) result[0], (Integer) result[1]);
			BigDecimal total = (BigDecimal) result[2];
			revenueByMonth.put(month, total);
		}

		return revenueByMonth;
	}

	@Override
    public Map<YearMonth, Map<String, BigDecimal>> getEmployeeTotalByMonth() {
        List<Object[]> results = hoaDonBanRepository.findTotalByEmployeeAndMonth();
        Map<YearMonth, Map<String, BigDecimal>> employeeRevenueByMonth = new HashMap<>();

        for (Object[] result : results) {
            String employeeName = (String) result[0];
            YearMonth yearMonth = YearMonth.of((Integer) result[1], (Integer) result[2]);
            BigDecimal total = (BigDecimal) result[3];

            employeeRevenueByMonth.computeIfAbsent(yearMonth, k -> new HashMap<>()).put(employeeName, total);
        }

        return employeeRevenueByMonth;
    }
	
	 @Override
	    public long countHoaDonBan() {
	        return hoaDonBanRepository.count();
	    }

	    @Override
	    public BigDecimal sumTotalHoaDonBan() {
	        return hoaDonBanRepository.sumTotal();
	    }
}
