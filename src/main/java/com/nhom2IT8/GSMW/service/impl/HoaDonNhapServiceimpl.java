package com.nhom2IT8.GSMW.service.impl;

import com.nhom2IT8.GSMW.entity.HoaDonNhap;
import com.nhom2IT8.GSMW.repository.HoaDonNhapRepository;
import com.nhom2IT8.GSMW.service.HoaDonNhapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class HoaDonNhapServiceimpl implements HoaDonNhapService {

    @Autowired
    private HoaDonNhapRepository hoaDonNhapRepository;

    @Override
    public List<HoaDonNhap> getAllHoaDonNhap() {
        return hoaDonNhapRepository.findAll();
    }

 
    @Override
    public List<HoaDonNhap> searchHoaDonNhap(String keyword) {
        return hoaDonNhapRepository.findByKeyword(keyword);
    }
    
    
    @Override
    public long countHoaDonNhap() {
        return hoaDonNhapRepository.count();
    }

    @Override
    public BigDecimal sumTotalHoaDonNhap() {
        return hoaDonNhapRepository.sumTotal();
    }
    @Override
    public void saveHoaDonNhap(HoaDonNhap hoaDonNhap) {
        hoaDonNhapRepository.save(hoaDonNhap);
    }
    
}
