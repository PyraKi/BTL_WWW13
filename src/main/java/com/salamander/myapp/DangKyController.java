package com.salamander.myapp;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.salamander.dao.EmailDAO;
import com.salamander.entities.KhachHang;
import com.salamander.entities.TaiKhoan;
import com.salamander.service.KhachHangService;
import com.salamander.service.TaiKhoanService;


@Controller
public class DangKyController {
	@Autowired
	public KhachHangService khService ;
	@Autowired
	public TaiKhoanService tkService ;
	
	
	@RequestMapping(value = {"/register" }, method = RequestMethod.GET)
	public ModelAndView dangKy() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("taiKhoan", new TaiKhoan());
		return mav;
	}
	@RequestMapping(value = "/addTK", method = RequestMethod.POST)
	public ModelAndView addTK(HttpServletRequest Request) {
		long id = 0;
			id=	(long)new Random().nextInt(100) + 1;
		String idkh = String.valueOf(id);
		String userName = Request.getParameter("userName");
		String password = Request.getParameter("password");
		String name = Request.getParameter("name");
		String email = Request.getParameter("email");
		String sdt = Request.getParameter("sdt");
		String ngsinh = Request.getParameter("ngsinh");
		String gt = Request.getParameter("gt");
		String dc = Request.getParameter("dc");
		String quyen = "KH";
		
		TaiKhoan tk = new TaiKhoan( userName, password, quyen);
	
		tkService.addTK(tk);
		
		KhachHang kh = new KhachHang(idkh, name, sdt, email, gt, ngsinh, dc);
		kh.setTk(tk);
		khService.addKH(kh);
		
		EmailDAO sentemail = new EmailDAO();
		sentemail.sendEmail(email, "Ðang ki", "Ban da dang ki thanh cong!");
		
		return new ModelAndView("redirect:Login","tenKH",kh.getTenKH());
	}
}
