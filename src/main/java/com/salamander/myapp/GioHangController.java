package com.salamander.myapp;

import java.time.LocalDateTime;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.salamander.bean.GioHang;
import com.salamander.bean.LoginUser;
import com.salamander.dao.EmailDAO;
import com.salamander.entities.ChiTietHoaDon;
import com.salamander.entities.HoaDon;
import com.salamander.entities.KhachHang;
import com.salamander.entities.SanPham;
import com.salamander.service.ChiTietHoaDonService;
import com.salamander.service.HoaDonService;
import com.salamander.service.KhachHangService;
import com.salamander.service.SanPhamService;
import com.salamander.session.GioHangSession;
import com.salamander.session.LoginSession;

@Controller
public class GioHangController {
	@Autowired
	HoaDonService hdService;
	@Autowired
	ChiTietHoaDonService cthdService;
	@Autowired
	SanPhamService spService;
	@Autowired
	KhachHangService khService;
	@RequestMapping(value = {"/addGioHang" }, method = RequestMethod.POST)
	public String  addGiohang(HttpServletRequest request , Model model ) {
		long idsp = Long.valueOf(request.getParameter("idsp"));
		GioHang gh = GioHangSession.getGioHangSession(request);
		System.out.println("gh"+gh);
		 SanPham sp = spService.getPersonById(idsp);
		 System.out.println("sp"+sp);
		boolean t = gh.addSP(spService.getPersonById(idsp));
		System.out.println("t"+t);
		return "redirect:/index";
	}
	@RequestMapping(value = "/Giohang", method = RequestMethod.GET)
	public String cartShow(HttpServletRequest request, Model model) {
		GioHang gh = GioHangSession.getGioHangSession(request);
		model.addAttribute("gioHang", gh.getChiTietHoaDons());
		model.addAttribute("tongDonHang", gh.total());
		return "Giohang";
	}
	@RequestMapping(value = "/removeGioHang", method = RequestMethod.POST)
	public String cartRemoveGioHang(@RequestParam Integer index, HttpServletRequest request) {
		GioHang gh = GioHangSession.getGioHangSession(request);
		gh.removeSP(index - 1);
		return "redirect:/Giohang";
	}
	@RequestMapping(value = "/Giohang", method = RequestMethod.POST)
	public String cartUpdateQuantity(@RequestParam Integer index, @RequestParam Integer soLuong, HttpServletRequest request, Model model) {
		GioHang gh = GioHangSession.getGioHangSession(request);
		gh.updateSP(index - 1, soLuong);
		return "redirect:/Giohang";
	}
	
	@RequestMapping(value = "/thanhToanGH", method = RequestMethod.POST)
	public String thanhToan(@RequestParam Long idsp, @RequestParam Integer soLuong, HttpServletRequest request, Model model) {                
		LoginUser login = LoginSession.getLoginSession(request);
		System.out.println("Login"+login.getTk());
		if(login.getTk() == null) {
			return "redirect:/Login";
		}
		System.out.println("issp+gh"+idsp);
		
		long count = Long.valueOf(new Random().nextInt(1000)+1);
		
		KhachHang kh = khService.getKH(login.getTk().getTaiKhoan());
		HoaDon hd = new HoaDon(count, LocalDateTime.now(),kh);
		hdService.addHD(hd);
		String dc = kh.getDiaChi();
		long coun1t = Long.valueOf(new Random().nextInt(1000)+1);
		SanPham sp = spService.getPersonById(idsp);
		ChiTietHoaDon cthd = new ChiTietHoaDon(coun1t, dc, soLuong , hd, sp);
		sp.setSoLuong(sp.getSoLuong() - soLuong);
		//spService.updateSanPham(sp);
		cthdService.addCTHD(cthd);
		request.getSession().setAttribute("cart", null);
		return "redirect:/index";
	}
	
	
}
