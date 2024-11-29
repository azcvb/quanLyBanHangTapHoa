package com.nhom2IT8.GSMW.controller;

import com.nhom2IT8.GSMW.entity.ChiTietHoaDon;
import com.nhom2IT8.GSMW.entity.SanPham;
import com.nhom2IT8.GSMW.service.BanHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/banhang")
public class BanHangController {

    @Autowired
    private BanHangService banHangService;

    @GetMapping
    public String quanLyBanHang(Model model) {
        List<SanPham> sanPhamList = banHangService.getAllSanPham();
        List<ChiTietHoaDon> gioHang = banHangService.getGioHang();
        model.addAttribute("sanPhamList", sanPhamList);
        model.addAttribute("gioHang", gioHang);
        return "quanlybanhang";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam("spId") String spId, @RequestParam("soLuong") int soLuong) {
        banHangService.addToCart(spId, soLuong);
        return "redirect:/banhang";
    }

    @PostMapping("/remove-from-cart")
    public String removeFromCart(@RequestParam("index") int index) {
        banHangService.removeFromCart(index);
        return "redirect:/banhang";
    }

    @PostMapping("/checkout")
    public String checkout(RedirectAttributes redirectAttributes) {
        banHangService.checkout(redirectAttributes);
        return "redirect:/banhang";
    }
}