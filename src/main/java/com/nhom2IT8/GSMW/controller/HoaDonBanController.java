package com.nhom2IT8.GSMW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhom2IT8.GSMW.service.HoaDonBanService;

@Controller
public class HoaDonBanController {

    @Autowired
    private HoaDonBanService hoaDonBanService;

    @GetMapping("/hoadonban")
    public String getAllHoaDonBan(Model model) {
        model.addAttribute("hoadonbans", hoaDonBanService.getAllHoaDonBan());
        return "hoadonban";
    }

    @GetMapping("/hoadonban/search")
    public String searchHoaDonBan(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("hoadonbans", hoaDonBanService.searchHoaDonBan(keyword));
        return "hoadonban";


    }
}
