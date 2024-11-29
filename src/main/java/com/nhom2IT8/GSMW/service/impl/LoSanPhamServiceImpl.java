package com.nhom2IT8.GSMW.service.impl;


import com.nhom2IT8.GSMW.entity.HoaDonNhap;
import com.nhom2IT8.GSMW.entity.LoSanPham;
import com.nhom2IT8.GSMW.entity.SanPham;
import com.nhom2IT8.GSMW.repository.HoaDonNhapRepository;
import com.nhom2IT8.GSMW.repository.LoSanPhamRepository;
import com.nhom2IT8.GSMW.repository.SanPhamRepository;
import com.nhom2IT8.GSMW.service.LoSanPhamService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Service
public class LoSanPhamServiceImpl implements LoSanPhamService {

    @Autowired
    private LoSanPhamRepository loSanPhamRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private HoaDonNhapRepository hoaDonNhapRepository;
    
    @Override
    public List<LoSanPham> getAllLoSanPham() {
        return loSanPhamRepository.findAll();
    }

    @Override
    public LoSanPham getLoSanPhamById(String id) {
        return loSanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public void saveLoSanPham(LoSanPham loSanPham, RedirectAttributes redirectAttributes) {
        SanPham sanPham;
        
        Optional<SanPham> optionalSanPham = sanPhamRepository.findById(loSanPham.getLspSpId());
        
        if (optionalSanPham.isPresent()) {
            sanPham = optionalSanPham.get();
            loSanPham.setLspTenSanPham(sanPham.getSP_TenSanPham());
            loSanPham.setLspLoaiSanPham(sanPham.getSP_LoaiSanPham());
            sanPham.setSP_GiaBan(loSanPham.getLspGiaBanLe());
            sanPham.setSP_MoTa(loSanPham.getLspMoTa());
            sanPhamRepository.save(sanPham);
            loSanPham.setLspSpId(sanPham.getSP_id());
            redirectAttributes.addFlashAttribute("successMessage", "Thêm lô sản phẩm thành công!");
        } else {
        	sanPhamRepository.insertSanPham(
                    loSanPham.getLspTenSanPham(),
                    loSanPham.getLspLoaiSanPham(),
                    loSanPham.getLspGiaBanLe(),
                    loSanPham.getLspMoTa(),
                    0,
                    loSanPham.getLspSoLuong() > 0
                );
        	SanPham newSanPham = sanPhamRepository.findTen(loSanPham.getLspTenSanPham()).orElseThrow(() -> new RuntimeException("SanPham không tồn tại sau khi chèn"));
            loSanPham.setLspSpId(newSanPham.getSP_id());
            redirectAttributes.addFlashAttribute("successMessage", "Thêm lô sản phẩm và sản phẩm mới thành công!");
        }
        
        loSanPhamRepository.save(loSanPham);
    }


    @GetMapping("/getSanPham/{spId}")
    @ResponseBody
    public ResponseEntity<SanPham> getSanPham(@PathVariable String spId) {
        Optional<SanPham> sanPham = sanPhamRepository.findById(spId);
        if (sanPham.isPresent()) {
            return ResponseEntity.ok(sanPham.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @Override
    public void deleteLoSanPhamById(String id, RedirectAttributes redirectAttributes) {
        LoSanPham loSanPham = loSanPhamRepository.findById(id).orElse(null);
        if (loSanPham != null) {
            if (!hoaDonNhapRepository.existsByHdnLspId(id)) {
                List<LoSanPham> lspList = loSanPhamRepository.findByLspSpId(loSanPham.getLspSpId());
                if (lspList.size() == 1) {
                    sanPhamRepository.deleteById(loSanPham.getLspSpId());
                }
                loSanPhamRepository.deleteById(id);
                redirectAttributes.addFlashAttribute("successMessage", "Xóa lô sản phẩm thành công!");
            }else {
            	redirectAttributes.addFlashAttribute("errorMessage", "Không thể xóa lô sản phẩm vì lô sản phẩm đã được xuất hóa đơn nhập.");
            }
        }
    } 
    
    
    @Override
    public void updateLoSanPham(LoSanPham loSanPham, RedirectAttributes redirectAttributes) {
        LoSanPham existingLoSanPham = loSanPhamRepository.findById(loSanPham.getLspId()).orElse(null);
        if (existingLoSanPham != null) {
        	if (!hoaDonNhapRepository.existsByHdnLspId(loSanPham.getLspId())){
        		existingLoSanPham.setLspSpId(loSanPham.getLspSpId());
                existingLoSanPham.setLspNccId(loSanPham.getLspNccId());
                existingLoSanPham.setLspTenSanPham(loSanPham.getLspTenSanPham());
                existingLoSanPham.setLspLoaiSanPham(loSanPham.getLspLoaiSanPham());
                existingLoSanPham.setLspNgayNhap(loSanPham.getLspNgayNhap());
                existingLoSanPham.setLspDonGia(loSanPham.getLspDonGia());
                existingLoSanPham.setLspSoLuong(loSanPham.getLspSoLuong());
                existingLoSanPham.setLspThanhTien(loSanPham.getLspThanhTien());
                existingLoSanPham.setLspGiaBanLe(loSanPham.getLspGiaBanLe());
                existingLoSanPham.setLspMoTa(loSanPham.getLspMoTa());
                loSanPhamRepository.save(existingLoSanPham);
                redirectAttributes.addFlashAttribute("successMessage", "Sửa lô sản phẩm thành công!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Không thể sửa lô sản phẩm đã xuất hóa đơn!");
        }}
    }
    


    @Override
    public List<LoSanPham> searchLoSanPham(String keyword) {
        return loSanPhamRepository.findByLspTenSanPhamContainingIgnoreCase(keyword);
    }

    @Override
    public void exportInvoice(HoaDonNhap hoaDonNhap) {
        hoaDonNhapRepository.save(hoaDonNhap);
    }
}
