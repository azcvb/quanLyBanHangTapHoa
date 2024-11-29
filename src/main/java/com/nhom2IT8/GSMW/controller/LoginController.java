package com.nhom2IT8.GSMW.controller;

import com.nhom2IT8.GSMW.entity.TaiKhoan;
import com.nhom2IT8.GSMW.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "auth-login"; // Trả về view cho form đăng nhập
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, Model model) {
        TaiKhoan taiKhoan = taiKhoanService.findByUsernameAndPassword(username, password);
        if (taiKhoan != null) {
            return "redirect:/home"; // Chuyển hướng tới trang home nếu đăng nhập thành công
        } else {
        	model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng.");
            return "auth-login"; 
        }
    }
 
    @GetMapping("/home")
    public String home() {
        return "dashboard1"; //
    }

}
