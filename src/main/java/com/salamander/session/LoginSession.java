package com.salamander.session;


import java.time.Instant;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salamander.bean.LoginUser;
import com.salamander.entities.TaiKhoan;
import com.salamander.service.TaiKhoanService;

@Component
public class LoginSession {
	
	public static TaiKhoanService tks;
	@Autowired
	TaiKhoanService tkservice;
	@PostConstruct
	public void init() {
		LoginSession.tks = tkservice;
	}
	
	public static LoginUser getLoginSession(HttpServletRequest request) {
		LoginUser login = (LoginUser) request.getSession().getAttribute("login");
		if(login == null) {
			login = new LoginUser();
			request.getSession().setAttribute("login",login);
		}
		//System.out.println(login);
		return login;
	}
	
	public static void logout(HttpServletRequest request) {
		request.getSession().setAttribute("login", null);
	}
	public static  boolean signIn(HttpServletRequest request,TaiKhoan tk) {
		LoginUser login = getLoginSession(request);
		//System.out.println(login.getTk());
		if(login.getTk() != null) {
			return true;
		} else {
                    TaiKhoan tksession = tks.getTK(tk);
                    if(tk.getMatKhau().equalsIgnoreCase(tksession.getMatKhau())) {
                        login.setTk(tksession);
                        login.setLastLogin(Date.from(Instant.now()));
                        request.getSession().getAttribute("login");
                        return true;
                    }
		}
		return false;
	}
}
