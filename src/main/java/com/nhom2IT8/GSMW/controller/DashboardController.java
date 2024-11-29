package com.nhom2IT8.GSMW.controller;

import com.nhom2IT8.GSMW.service.ChiTietHoaDonService;
import com.nhom2IT8.GSMW.service.HoaDonBanService;
import com.nhom2IT8.GSMW.service.HoaDonNhapService;
import com.nhom2IT8.GSMW.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DashboardController {

    @Autowired
    private HoaDonBanService hoaDonBanService;
    
    @Autowired
    private HoaDonNhapService hoaDonNhapService;
    
    @Autowired
    private SanPhamService sanPhamService;
    
    @Autowired
    private ChiTietHoaDonService chiTietHoaDonService;
    
    @GetMapping("/thongke")
    public String getTotalRevenueByMonth(Model model) {
        Map<YearMonth, BigDecimal> revenueByMonth = hoaDonBanService.getTotalByMonth();
        model.addAttribute("revenueByMonth", revenueByMonth);

        Map<YearMonth, Map<String, BigDecimal>> employeeRevenueByMonth = hoaDonBanService.getEmployeeTotalByMonth();
        model.addAttribute("employeeRevenueByMonth", employeeRevenueByMonth);
        
        long soLuongHoaDonNhap = hoaDonNhapService.countHoaDonNhap();
        BigDecimal tongTienHoaDonNhap = hoaDonNhapService.sumTotalHoaDonNhap();

        long soLuongHoaDonBan = hoaDonBanService.countHoaDonBan();
        BigDecimal tongTienHoaDonBan = hoaDonBanService.sumTotalHoaDonBan();

        model.addAttribute("soLuongHoaDonNhap", soLuongHoaDonNhap);
        model.addAttribute("tongTienHoaDonNhap", tongTienHoaDonNhap);

        model.addAttribute("soLuongHoaDonBan", soLuongHoaDonBan);
        model.addAttribute("tongTienHoaDonBan", tongTienHoaDonBan);
        
        long soLuongSanPham = sanPhamService.countSanPham();
        BigDecimal tongSoLuongSanPham = sanPhamService.sumTotalSanPham();

        model.addAttribute("soLuongSanPham", soLuongSanPham);
        model.addAttribute("tongSoLuongSanPham", tongSoLuongSanPham);

        // Lấy dữ liệu thống kê sản phẩm
        List<Object[]> sanPhamStatistics = chiTietHoaDonService.getSanPhamStatistics();
        model.addAttribute("sanPhamStatistics", sanPhamStatistics);

        return "dashboard1";
    }

    @GetMapping("/thongke/json")
    @ResponseBody
    public Map<String, Object> getTotalRevenueByMonthJson() {
        Map<YearMonth, BigDecimal> revenueByMonth = hoaDonBanService.getTotalByMonth();
        Map<String, Object> response = new HashMap<>();
        response.put("labels", revenueByMonth.keySet().stream().map(YearMonth::toString).toArray(String[]::new));
        response.put("data", revenueByMonth.values().toArray(BigDecimal[]::new));
        return response;
    }

    @GetMapping("/thongke/nhanvien/json")
    @ResponseBody
    public Map<String, Object> getEmployeeRevenueByMonthJson() {
        Map<YearMonth, Map<String, BigDecimal>> employeeRevenueByMonth = hoaDonBanService.getEmployeeTotalByMonth();
        Map<String, Object> response = new HashMap<>();
        response.put("labels", employeeRevenueByMonth.keySet().stream().map(YearMonth::toString).toArray(String[]::new));
        response.put("data", employeeRevenueByMonth.values().stream().map(Map::values).map(values -> values.toArray(BigDecimal[]::new)).toArray(BigDecimal[][]::new));
        return response;
    }

    @GetMapping("/thongke/sanpham/json")
    @ResponseBody
    public Map<String, Object> getSanPhamStatisticsJson() {
        List<Object[]> sanPhamStatistics = chiTietHoaDonService.getSanPhamStatistics();
        Map<String, Object> response = new HashMap<>();
        response.put("labels", sanPhamStatistics.stream().map(stat -> (String) stat[0]).toArray(String[]::new));
        response.put("data", sanPhamStatistics.stream().map(stat -> ((Number) stat[1]).intValue()).toArray(Integer[]::new));
        return response;
    }
}
