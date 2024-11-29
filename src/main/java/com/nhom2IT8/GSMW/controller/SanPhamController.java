package com.nhom2IT8.GSMW.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhom2IT8.GSMW.entity.SanPham;
import com.nhom2IT8.GSMW.service.SanPhamService;

@Controller
public class SanPhamController {
	@Autowired
	private SanPhamService sanPhamService;

	@GetMapping("/sanphams")
	public String viewHomePage(Model model) {
		model.addAttribute("sanphams", sanPhamService.getSanPhams());
		return "sanphams";
	}

	@GetMapping("/sanphams/new")
	public String createSanPhamForm(Model model) {
		SanPham sanpham = new SanPham();
		model.addAttribute("sanpham", sanpham);
		return "create";
	}


    @PostMapping("/sanphams/saveSanPham")
    public String saveSanPham(@ModelAttribute("sanpham") SanPham sanpham) {
        // Sử dụng service để cập nhật hoặc lưu sản phẩm
        sanPhamService.saveSanPham(sanpham);
        
        return "redirect:/sanphams";
    }

    @PostMapping("/sanphams/updateSanPham")
    public String updateSanPham(@ModelAttribute("sanpham") SanPham sanpham) {
       
        
        // Sử dụng service để cập nhật sản phẩm
        sanPhamService.updateSanPham(sanpham);
        
        return "redirect:/sanphams";
    }


	// Hiển thị form sửa sản phẩm
	@GetMapping("/sanphams/sua/{id}") public String showFormForUpdate(@PathVariable(value = "id") String id,
			Model model) {
		// get employee from the service
		SanPham sanpham = sanPhamService.getSanPhamById(id);
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("sanphams", sanpham);
		return "sua";
	}

	@GetMapping("/sanphams/xoa/{id}")
	public String deleteSanPham(@PathVariable String id) {
		sanPhamService.deleteSanPhamById(id);
		return "redirect:/sanphams";
	}

	@GetMapping("/sanphams/timkiem")
	public String searchSanPham(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "tenSanPham", required = false) String tenSanPham,
			@RequestParam(value = "loaiSanPham", required = false) String loaiSanPham,
			@RequestParam(value = "giaBan", required = false) BigDecimal giaBan,
			@RequestParam(value = "moTa", required = false) String moTa,
			@RequestParam(value = "soLuong", required = false) Integer soLuong,
			@RequestParam(value = "trangThai", required = false) Boolean trangThai, Model model) {
		List<SanPham> sanPhams = sanPhamService.searchSanPham(id, tenSanPham, loaiSanPham, giaBan, moTa, soLuong,
				trangThai);
		model.addAttribute("sanphams", sanPhams);
		return "sanphams";
	}
}
