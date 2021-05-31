package com.salamander.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.salamander.entities.LoaiSanPham;
import com.salamander.service.LoaiSanPhamService;

@Controller
public class AddLoaiSPController {
	@Autowired
	public LoaiSanPhamService lspService;
	
	@RequestMapping(value = {"/addLoaisp" }, method = RequestMethod.GET)
	public ModelAndView addLoaisp() {
		ModelAndView mav = new ModelAndView("addLoaisp");
		mav.addObject("loaisanpham", new LoaiSanPham());
		return mav;
	}
	@RequestMapping(value = "/addlsp", method = RequestMethod.POST)
	public ModelAndView addlsp(HttpServletRequest Request) {
		String id = Request.getParameter("idlsp");
			
		long idlsp = Long.parseLong(id);
		String namelsp = Request.getParameter("namelsp");
		LoaiSanPham lsp = new LoaiSanPham(idlsp, namelsp);
		
		lspService.addLSP(lsp);
				
		return new ModelAndView("redirect:/Quanlylsp","tenLSP",lsp.getTenLoaiSP());
	}
}
