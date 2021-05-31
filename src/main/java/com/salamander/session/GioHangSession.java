package com.salamander.session;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.salamander.bean.GioHang;
import com.salamander.entities.ChiTietHoaDon;
import com.salamander.entities.HoaDon;
import com.salamander.entities.KhachHang;
import com.salamander.entities.SanPham;
import com.salamander.service.ChiTietHoaDonService;
import com.salamander.service.HoaDonService;
import com.salamander.service.SanPhamService;

public class GioHangSession {
	private static HoaDonService hds;
	private static ChiTietHoaDonService cthds;
	private static SanPhamService sps;
	@Autowired
	HoaDonService hdservice;
	@Autowired
	ChiTietHoaDonService cthdservice;
	@Autowired
	SanPhamService spservice;
	@PostConstruct
	public void init() {
		GioHangSession.hds = hdservice;
		GioHangSession.cthds = cthdservice;
		GioHangSession.sps = spservice;
	}
	
	public static GioHang getGioHangSession(HttpServletRequest request) {
		GioHang gioHang = (GioHang) request.getSession().getAttribute("cart");
		if(gioHang == null) {
			gioHang = new GioHang();
			request.getSession().setAttribute("cart", gioHang);
		}
		return gioHang;
	}
	public static void removeCartInSession(HttpServletRequest request) {
		request.getSession().removeAttribute("cart");
	}
	public static boolean thanhToan (GioHang gh , KhachHang kh ,String diaChiGiaohang) {
		
		HoaDon  hd = new HoaDon();
		long id = 0;
		id=	(long)new Random().nextInt(100) + 1;
		hd.setIdMaHD(id);
		hd.setDsCTHD(new ArrayList<ChiTietHoaDon>());
		hd.setNgayLapHoaDon(LocalDateTime.now());
		hd.setKh(kh);
		
		hds.addHD(hd);
		
		List<ChiTietHoaDon> cthdtemp =  gh.getChiTietHoaDons();
		cthdtemp.forEach(x->{
			long idct = 0;
			idct=	(long)new Random().nextInt(100) + 1;
			ChiTietHoaDon ct = new ChiTietHoaDon(idct, diaChiGiaohang, x.getSoLuongMua(), hd, x.getSanPham());
			cthds.addCTHD(ct);
			SanPham sp = x.getSanPham();
			sp.setSoLuong(sp.getSoLuong() - x.getSoLuongMua());
			sps.updateSanPham(sp);
		});
		return true;
	}
}
