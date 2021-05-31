package com.salamander.myapp;

import com.salamander.bean.GioHang;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.salamander.entities.SanPham;
import com.salamander.service.LoaiSanPhamService;
import com.salamander.service.SanPhamService;
import com.salamander.session.GioHangSession;
import org.springframework.ui.Model;


@Controller
public class ChiTietSanPhamController {
	@Autowired
	public LoaiSanPhamService lspService;
	@Autowired
	public SanPhamService spService;
	@RequestMapping(value = {"/{name}" }, method = RequestMethod.GET)
	public ModelAndView dangKy(@PathVariable String name , HttpServletRequest request, Model model) {	
            long id = lspService.listLSP(name);
            System.out.println("id1"+id);
            List<SanPham> dssp = spService.getPersonByIds(id);
            ModelAndView mav = new ModelAndView(name,"dssp",dssp);
            GioHang gh = GioHangSession.getGioHangSession(request);
            model.addAttribute("gh", gh);
            return mav;	
	}
	@RequestMapping(value = {"/chiTietSP" }, method = RequestMethod.GET)
	public ModelAndView CTSP ( HttpServletRequest request, Model model) {
            long id = Long.valueOf(request.getParameter("idsp"));
            GioHang gh = GioHangSession.getGioHangSession(request);
            model.addAttribute("gh", gh);
            SanPham sp = spService.getPersonById(id);
            ModelAndView mav = new ModelAndView("chiTietSP","sp",sp);
            return mav;					
	}
}
