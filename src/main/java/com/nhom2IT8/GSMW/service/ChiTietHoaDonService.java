package com.nhom2IT8.GSMW.service;

import com.nhom2IT8.GSMW.repository.ChiTietHoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietHoaDonService {

    @Autowired
    private ChiTietHoaDonRepository chiTietHoaDonRepository;

    public List<Object[]> getSanPhamStatistics() {
        return chiTietHoaDonRepository.getSanPhamStatistics();
    }
}
