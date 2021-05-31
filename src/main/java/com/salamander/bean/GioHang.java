package com.salamander.bean;

import java.util.ArrayList;
import java.util.List;

import com.salamander.entities.ChiTietHoaDon;
import com.salamander.entities.KhachHang;
import com.salamander.entities.SanPham;
import com.salamander.entities.TaiKhoan;

public class GioHang {
	private long idGH;
	private List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<ChiTietHoaDon>();
	private TaiKhoan tk;
	private KhachHang kh;
	
	public GioHang() {
		// TODO Auto-generated constructor stub
	}

	public GioHang(long idGH, List<ChiTietHoaDon> chiTietHoaDons, TaiKhoan tk, KhachHang kh) {
		super();
		this.idGH = idGH;
		this.chiTietHoaDons = chiTietHoaDons;
		this.tk = tk;
		this.kh = kh;
	}

	public long getIdGH() {
		return idGH;
	}

	public void setIdGH(long idGH) {
		this.idGH = idGH;
	}

	public List<ChiTietHoaDon> getChiTietHoaDons() {
		return chiTietHoaDons;
	}

	public void setChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {
		this.chiTietHoaDons = chiTietHoaDons;
	}

	public TaiKhoan getTk() {
		return tk;
	}

	public void setTk(TaiKhoan tk) {
		this.tk = tk;
	}

	public KhachHang getKh() {
		return kh;
	}

	public void setKh(KhachHang kh) {
		this.kh = kh;
	}
	public boolean addSP(SanPham sp) {
		System.out.println("sp"+sp);
		int count = 0;
		for(ChiTietHoaDon cthd : chiTietHoaDons) {
			if(cthd.getSanPham().getIdSP() == sp.getIdSP()) {
				cthd.setSoLuongMua(cthd.getSoLuongMua() + 1);
				total();
				return true;
			}
		}
		return chiTietHoaDons.add(new ChiTietHoaDon(count++, null, 1, null, sp));
	}
	public boolean updateSP(int index , int soLuong) {
		ChiTietHoaDon cthd = chiTietHoaDons.get(index);
		cthd.setSoLuongMua(soLuong);
		chiTietHoaDons.set(index, cthd);
		total();
		return true;
	}
	
	public boolean removeSP(int index) {
		chiTietHoaDons.remove(index);
		total();
		return true;
	}
	public double total() {
		double tong = 0;
		for(ChiTietHoaDon  cthd : chiTietHoaDons) {
			tong += cthd.tong();
		}
		return tong;
	}

	@Override
	public String toString() {
		return "GioHang [idGH=" + idGH + ", chiTietHoaDons=" + chiTietHoaDons + ", tk=" + tk + ", kh=" + kh + "]";
	}
	
}
