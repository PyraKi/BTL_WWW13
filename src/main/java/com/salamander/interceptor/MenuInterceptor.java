package com.salamander.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.salamander.service.MenuService;

public class MenuInterceptor implements HandlerInterceptor{
	@Autowired
	MenuService menuService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("menus", menuService.getTenlsp());
		return true;
	}
}
