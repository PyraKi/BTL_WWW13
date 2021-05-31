package com.salamander.myapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.salamander.bean.LoginUser;

import com.salamander.entities.TaiKhoan;
import com.salamander.service.KhachHangService;
import com.salamander.service.TaiKhoanService;
import com.salamander.session.LoginSession;

@Controller
public class DangNhapController {
	@Autowired
	TaiKhoanService tkService;
	@Autowired
	KhachHangService khService;
	
	
	
	@RequestMapping(value = {"/Login", "/login"}, method = RequestMethod.GET)
	public String  dangNhap(HttpServletRequest request , Model model ) {
		LoginUser login = LoginSession.getLoginSession(request);
		if(login.getTk() != null) {
			return "redirect:/index";
		} 
			return "Login";
		
	}

	@RequestMapping(value = {"/checkLogin" }, method = RequestMethod.POST)
	public ModelAndView checkLogin(HttpServletRequest Request, HttpSession session, Model model) {
            String userName = Request.getParameter("userName").trim();
            String password = Request.getParameter("password").trim();
            if(userName != "" && password != ""){
                TaiKhoan taiKhoan  = new TaiKhoan(userName,password);
                    boolean temp = LoginSession.signIn(Request, taiKhoan);
                    String role = tkService.checkTK(taiKhoan);
                    if(temp && role != null) {
                        if(role.equalsIgnoreCase("KH")) {
                                return new ModelAndView("redirect:/index","gettk",userName);
                        } 
                        if(role.equalsIgnoreCase("Admin")) {
                                return new ModelAndView("redirect:/Quanlysp","gettk",userName);
                        }	
                    } else {
                        model.addAttribute("login-warning", true);
                        return new ModelAndView("Login");
                    }
                }
            model.addAttribute("login-warning", true);
            return new ModelAndView("Login");
	}
	@RequestMapping(value = {"/logout" }, method = RequestMethod.GET)
	public String  dangXuat(HttpServletRequest request , Model model ) {
		LoginUser login = LoginSession.getLoginSession(request);
		if(login.getTk() != null) {
			LoginSession.logout(request);
			return "redirect:/Login";
		} 
			return "Login";
		
	}
}
