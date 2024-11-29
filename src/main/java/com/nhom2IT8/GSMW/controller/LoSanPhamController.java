package com.nhom2IT8.GSMW.controller;


import com.nhom2IT8.GSMW.entity.HoaDonNhap;
import com.nhom2IT8.GSMW.entity.LoSanPham;
import com.nhom2IT8.GSMW.service.LoSanPhamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/quanlykho")
public class LoSanPhamController {

	@Autowired
	private LoSanPhamService loSanPhamService;

	@GetMapping
	public String viewHomePage(Model model) {
		List<LoSanPham> listLoSanPham = loSanPhamService.getAllLoSanPham();
		model.addAttribute("loSanPhamList", listLoSanPham);
		return "quanlykho";
	}

	@PostMapping("/add")
	public String addLoSanPham(@ModelAttribute LoSanPham loSanPham, RedirectAttributes redirectAttributes) {
		loSanPhamService.saveLoSanPham(loSanPham, redirectAttributes);
		return "redirect:/quanlykho";
	}

	@PostMapping("/update")
    public String updateLoSanPham(@ModelAttribute LoSanPham loSanPham, RedirectAttributes redirectAttributes) {
		loSanPhamService.updateLoSanPham(loSanPham, redirectAttributes);
		return "redirect:/quanlykho";
    }

	@PostMapping("/search")
	public String searchLoSanPham(@RequestParam("keyword") String keyword, Model model) {
		List<LoSanPham> result = loSanPhamService.searchLoSanPham(keyword);
		model.addAttribute("loSanPhamList", result);
		return "quanlykho";
	}

	@PostMapping("/invoice")
	public String exportInvoice(@RequestParam("lspId") String id, RedirectAttributes redirectAttributes ) {
		LoSanPham loSanPham = loSanPhamService.getLoSanPhamById(id);
		if (loSanPham != null) {
			HoaDonNhap hoaDonNhap = new HoaDonNhap();
			hoaDonNhap.setHdnLspId(loSanPham.getLspId());
			hoaDonNhap.setHdnDonGia(loSanPham.getLspDonGia());
			hoaDonNhap.setHdnSoLuong(loSanPham.getLspSoLuong());
			hoaDonNhap.setHdnThanhTien(loSanPham.getLspThanhTien());
			hoaDonNhap.setHdnNgayXuatHoaDon(LocalDateTime.now());
			loSanPhamService.exportInvoice(hoaDonNhap);
		}
		redirectAttributes.addFlashAttribute("successMessage", "Xuất hóa đơn thành công!");
		return "redirect:/quanlykho";
	}

	@PostMapping("/delete")
	public String deleteLoSanPham(@RequestParam("lspId") String id, RedirectAttributes redirectAttributes) {
		loSanPhamService.deleteLoSanPhamById(id, redirectAttributes);
		return "redirect:/quanlykho";
	}

}
