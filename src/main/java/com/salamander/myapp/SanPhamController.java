package com.salamander.myapp;


import com.salamander.bean.GioHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.salamander.entities.SanPham;
import com.salamander.service.SanPhamService;
import com.salamander.session.GioHangSession;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SanPhamController {
	
	@Autowired
	private SanPhamService sanPhamService;

	@RequestMapping(value = {"/index","/" }, method = RequestMethod.GET) 
	public String listSanPham(HttpServletRequest request, Model model) {
            model.addAttribute("sanpham",new SanPham());
            GioHang gh = GioHangSession.getGioHangSession(request);
            model.addAttribute("gh", gh);
            model.addAttribute("dssp", this.sanPhamService.listSanPhams());
            return "index";
	}

	
}
