package com.nhom2IT8.GSMW.controller;

import com.nhom2IT8.GSMW.entity.HoaDonNhap;
import com.nhom2IT8.GSMW.service.HoaDonNhapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HoaDonNhapController {

    @Autowired
    private HoaDonNhapService hoaDonNhapService;

    @GetMapping("/hoadonnhap")
    public String showHoaDonNhap(Model model) {
        List<HoaDonNhap> hoaDonNhapList = hoaDonNhapService.getAllHoaDonNhap();
        model.addAttribute("hoaDonNhapList", hoaDonNhapList);
        return "hoadonnhap"; 
    }
 // Trong HoaDonNhapController.java
    @GetMapping("/hoadonnhap/search")
    public String searchHoaDonNhap(@RequestParam("keyword") String keyword, Model model) {
        List<HoaDonNhap> hoaDonNhapList = hoaDonNhapService.searchHoaDonNhap(keyword);
        model.addAttribute("hoaDonNhapList", hoaDonNhapList);
        return "hoadonnhap"; 
    }
    
}
