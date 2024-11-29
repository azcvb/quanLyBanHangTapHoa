package com.nhom2IT8.GSMW.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhom2IT8.GSMW.entity.NhaCungCap;
import com.nhom2IT8.GSMW.service.NhaCungCapService;



@Controller
public class NhaCungCapController {
	
	@Autowired
    private NhaCungCapService nccservice;
	
	 @GetMapping("/ncc")
	    public String homeNCC(Model model) {
	        model.addAttribute("nccs", nccservice.getNCC());
	        return "nhacungcap";
	    }
	    

	    
	    @PostMapping("/ncc/saveNcc")
	    public String updateNcc(@ModelAttribute("ncc") NhaCungCap ncc) {
	    	nccservice.saveNcc(ncc);
	    	return "redirect:/ncc";
	    }
	    
		@GetMapping("/ncc/xoa/{id}")
		public String deleteNcc(@PathVariable String id) {
			nccservice.delNcc(id);
			return "redirect:/ncc";
		}
	    
		@GetMapping("/ncc/timkiem")
		public String searchNCC(
		        @RequestParam(value = "ncc_id", required = false) String id,
		        @RequestParam(value = "ncc_ten", required = false) String tenNcc,
		        @RequestParam(value = "ncc_sdt", required = false) String sdtNcc,
		        @RequestParam(value = "ncc_email", required = false) String emailNcc,
		        @RequestParam(value = "ncc_diaChi", required = false) String diachiNcc,
		        Model model) {
		    
		    List<NhaCungCap> nccs = nccservice.searchNcc(id, tenNcc, sdtNcc, emailNcc, diachiNcc);
		    model.addAttribute("nccs", nccs);
		    return "nhacungcap";
		}

}
