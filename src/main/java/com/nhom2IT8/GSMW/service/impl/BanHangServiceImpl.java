package com.nhom2IT8.GSMW.service.impl;

import com.nhom2IT8.GSMW.entity.ChiTietHoaDon;
import com.nhom2IT8.GSMW.entity.HoaDonBan;
import com.nhom2IT8.GSMW.entity.SanPham;
import com.nhom2IT8.GSMW.repository.ChiTietHoaDonRepository;
import com.nhom2IT8.GSMW.repository.HoaDonBanRepository;
import com.nhom2IT8.GSMW.repository.SanPhamRepository;
import com.nhom2IT8.GSMW.service.BanHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BanHangServiceImpl implements BanHangService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private ChiTietHoaDonRepository chiTietHoaDonRepository;

    private List<ChiTietHoaDon> gioHang = new ArrayList<>();
    
    @Autowired
    private HoaDonBanRepository hoaDonBanRepository;
    
    @Override
    public List<SanPham> getAllSanPham() {
        return sanPhamRepository.findAll();
    }


    @Override
    public void addToCart(String spId, int soLuong) {
        Optional<SanPham> sanPhamOptional = sanPhamRepository.findById(spId);
        if (sanPhamOptional.isPresent()) {
            SanPham sanPham = sanPhamOptional.get();
            Optional<ChiTietHoaDon> existingCartItem = gioHang.stream()
                    .filter(item -> item.getSanPham().getSP_id().equals(sanPham.getSP_id()))
                    .findFirst();

            if (existingCartItem.isPresent()) {
                ChiTietHoaDon chiTietHoaDon = existingCartItem.get();
                chiTietHoaDon.setCthdSoLuong(chiTietHoaDon.getCthdSoLuong() + soLuong);
                chiTietHoaDon.setCthdThanhTien(chiTietHoaDon.getSanPham().getSP_GiaBan().multiply(BigDecimal.valueOf(chiTietHoaDon.getCthdSoLuong())));
            } else {
                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                chiTietHoaDon.setSanPham(sanPham);
                chiTietHoaDon.setCthdSoLuong(soLuong);
                chiTietHoaDon.setCthdDonGia(sanPham.getSP_GiaBan());
                chiTietHoaDon.setCthdThanhTien(sanPham.getSP_GiaBan().multiply(BigDecimal.valueOf(soLuong)));
                gioHang.add(chiTietHoaDon);
            }
        }
    }



    @Override
    @Transactional
    public void checkout(RedirectAttributes redirectAttributes) {
        HoaDonBan hoaDonBan = new HoaDonBan();
        hoaDonBan.setHdbNgayXuat(LocalDateTime.now());
        
        BigDecimal tongTien = gioHang.stream()
                .map(ChiTietHoaDon::getCthdThanhTien)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        hoaDonBan.setHdbTongTien(tongTien);

        hoaDonBan = hoaDonBanRepository.save(hoaDonBan); 
        hoaDonBanRepository.flush();

        String hdbId = hoaDonBanRepository.findLatestHdbId();

        for (ChiTietHoaDon chiTietHoaDon : gioHang) {
            SanPham sanPham = chiTietHoaDon.getSanPham();

            int newSoLuong = sanPham.getSP_SoLuong() - chiTietHoaDon.getCthdSoLuong();
            if (newSoLuong < 0) {
            	redirectAttributes.addFlashAttribute("errorMessage", "Sản phẩm đã hết hàng!");
            }
            sanPham.setSP_SoLuong(newSoLuong);
            sanPhamRepository.save(sanPham); 

            chiTietHoaDonRepository.insertChiTietHoaDon(
                    hdbId, 
                    sanPham.getSP_id(),
                    chiTietHoaDon.getCthdDonGia(),
                    chiTietHoaDon.getCthdSoLuong(),
                    chiTietHoaDon.getCthdThanhTien()
            );
        }
        redirectAttributes.addFlashAttribute("successMessage", "Hoàn thành! Đã xuất hóa đơn bán!");
        gioHang.clear();
    }



    
    @Override
    public void removeFromCart(int index) {
        if (index >= 0 && index < gioHang.size()) {
            gioHang.remove(index);
        }
    }

    @Override
    public List<ChiTietHoaDon> getGioHang() {
        return gioHang;
    }
    
}
