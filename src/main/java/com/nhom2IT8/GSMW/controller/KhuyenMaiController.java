package com.nhom2IT8.GSMW.controller;

import com.nhom2IT8.GSMW.entity.GiamGia;
import com.nhom2IT8.GSMW.entity.TangQua;
import com.nhom2IT8.GSMW.service.GiamGiaService;
import com.nhom2IT8.GSMW.service.TangQuaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/khuyenmai")
public class KhuyenMaiController {

    private final GiamGiaService giamGiaService;
    private final TangQuaService tangQuaService;

    public KhuyenMaiController(GiamGiaService giamGiaService,
                               TangQuaService tangQuaService) {
        this.giamGiaService = giamGiaService;
        this.tangQuaService = tangQuaService;
    }

    @GetMapping
    public String khuyenmai() {
        return "khuyenmai";
    }

    @GetMapping("/giamgia")
    public String giamgia(Model model) {
        model.addAttribute("listGiamGia", giamGiaService.getAll());
        return "giamgia";
    }

    @GetMapping("/giamgia/form-create")
    public String formCreate(Model model) {
        GiamGia giamGia = new GiamGia();
        model.addAttribute("giamgia", giamGia);
        return "new_giamgia";
    }

    @PostMapping("/giamgia/create")
    public String create(@ModelAttribute GiamGia giamGia) {
        giamGiaService.createOrUpdate(giamGia);
        return "redirect:/khuyenmai/giamgia";
    }

    @GetMapping("/giamgia/form-update/{id}")
    public String formUpdate(@PathVariable(value = "id") String id, Model model) {
        GiamGia giamGia = giamGiaService.getById(id);
        model.addAttribute("giamGia", giamGia);
        return "update_giamgia";
    }

    @PostMapping("/giamgia/update")
    public String update(@ModelAttribute GiamGia giamGia) {
        giamGiaService.createOrUpdate(giamGia);
        return "redirect:/khuyenmai/giamgia";
    }

    @GetMapping("/giamgia/search")
    public String search(Model model, String keyword) {
        List<GiamGia> listGiamGia = giamGiaService.search(keyword);
        model.addAttribute("listGiamGia", listGiamGia);
        return "giamgia";
    }

    @GetMapping("/tangqua")
    public String tangqua(Model model) {
        model.addAttribute("listTangQua", tangQuaService.getAll());
        return "tangqua";
    }

    @GetMapping("/tangqua/form-create")
    public String formCreateTangQua(Model model) {
        TangQua tangQua = new TangQua();
        model.addAttribute("tangQua", tangQua);
        return "new_tangqua";
    }

    @PostMapping("/tangqua/create")
    public String createTangQua(@ModelAttribute TangQua tangQua) {
        tangQuaService.save(tangQua);
        return "redirect:/khuyenmai/tangqua";
    }

    @GetMapping("/tangqua/form-update/{id}")
    public String formUpdateTangQua(@PathVariable(value = "id") String id, Model model) {
        TangQua tangQua = tangQuaService.getById(id);
        model.addAttribute("tangQua", tangQua);
        return "update_tangqua";
    }

    @PostMapping("/tangqua/update")
    public String updateTangQua(@ModelAttribute TangQua tangQua) {
        tangQuaService.update(tangQua);
        return "redirect:/khuyenmai/tangqua";
    }

    @GetMapping("/tangqua/delete/{id}")
    public String deleteTangQua(@PathVariable String id) {
        tangQuaService.delete(id);
        return "redirect:/khuyenmai/tangqua";
    }

    @GetMapping("/tangqua/search")
    public String searchTangQua(Model model, String keyword) {
        List<TangQua> listTangQua = tangQuaService.search(keyword);
        model.addAttribute("listTangQua", listTangQua);
        return "tangqua";
    }
}
