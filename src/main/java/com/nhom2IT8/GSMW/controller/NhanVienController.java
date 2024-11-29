package com.nhom2IT8.GSMW.controller;

import com.nhom2IT8.GSMW.entity.NhanVien;
import com.nhom2IT8.GSMW.entity.TaiKhoan;
import com.nhom2IT8.GSMW.model.NhanVienRequest;
import com.nhom2IT8.GSMW.service.NhanVienService;
import com.nhom2IT8.GSMW.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    private final TaiKhoanService taiKhoanService;

    public NhanVienController(TaiKhoanService taiKhoanService) {
        this.taiKhoanService = taiKhoanService;
    }

    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("listNhanVien", nhanVienService.getAllNhanVien());
        return "nhanvien";
    }

    @GetMapping("/showNewNhanVienForm")
    public String showNewNhanVienForm(Model model) {
        NhanVien nhanVien = new NhanVien();
        model.addAttribute("nhanVien", nhanVien);
        return "new_nhanvien";
    }

    @PostMapping("/saveNhanVien")
    public String saveNhanVien(@ModelAttribute( "nhanVien") NhanVien nhanVien) {
        nhanVienService.createNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) {
        NhanVien nhanVienEntity = nhanVienService.getNhanVienById(id);
        NhanVienRequest nhanVien = new NhanVienRequest();
        nhanVien.setNV_id(nhanVienEntity.getNV_ID());
        nhanVien.setNV_tk_id(nhanVienEntity.getNV_TK_ID());
        nhanVien.setNV_ten(nhanVienEntity.getNV_Ten());
        nhanVien.setNV_gioitinh(nhanVienEntity.getNV_GioiTinh());
        nhanVien.setNV_ngaysinh(nhanVienEntity.getNV_NgaySinh());
        nhanVien.setNV_sdt(nhanVienEntity.getNV_SDT());
        nhanVien.setNV_email(nhanVienEntity.getNV_Email());
        nhanVien.setNV_diachi(nhanVienEntity.getNV_DiaChi());
        nhanVien.setNV_luong(nhanVienEntity.getNV_Luong());
        TaiKhoan taiKhoan = taiKhoanService.getById(nhanVien.getNV_tk_id());
        nhanVien.setNV_password(taiKhoan.getTK_Password());
        model.addAttribute("nhanVien", nhanVien);
        return "update_nhanvien";
    }

    @PostMapping("/updateNhanVien")
    public String updateNhanVien(@ModelAttribute("nhanVien") NhanVienRequest nhanVien) {
        nhanVienService.updateNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/deleteNhanVien/{id}")
    public String deleteNhanVien(@PathVariable(value = "id") String id) {
        this.nhanVienService.deleteNhanVien(id);
        return "redirect:/nhanvien";
    }

    @GetMapping("/search")
    public String search(Model model, String keyword) {
        List<NhanVien> listNhanVien = nhanVienService.search(keyword);
        model.addAttribute("listNhanVien", listNhanVien);
        return "nhanvien";
    }

}
