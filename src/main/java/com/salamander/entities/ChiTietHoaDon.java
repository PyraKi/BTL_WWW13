package com.salamander.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="ChiTietHoaDon")
public class ChiTietHoaDon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long idCTHD;

	private String diaChiGiaoDich;
	private int soLuongMua;
	@ManyToOne
	@JoinColumn(name = "idHD " , nullable = false)
	private HoaDon hd;
	
	
	@ManyToOne
	@JoinColumn(name = "idSP" , nullable = false,foreignKey = @ForeignKey)
	private SanPham sanPham;
	public ChiTietHoaDon() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ChiTietHoaDon(long idCTHD, String diaChiGiaoDich, int soLuongMua, HoaDon hd, SanPham sanPham) {
		super();
		this.idCTHD = idCTHD;
		this.diaChiGiaoDich = diaChiGiaoDich;
		this.soLuongMua = soLuongMua;
		this.hd = hd;
		this.sanPham = sanPham;
	}



	public String getDiaChiGiaoDich() {
		return diaChiGiaoDich;
	}
	public void setDiaChiGiaoDich(String diaChiGiaoDich) {
		this.diaChiGiaoDich = diaChiGiaoDich;
	}
	public long getIdCTHD() {
		return idCTHD;
	}
	public void setIdCTHD(long idCTHD) {
		this.idCTHD = idCTHD;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [idCTHD=" + idCTHD + ", ngayLapHoaDon="+ ", diaChiGiaoDich="
				+ diaChiGiaoDich + "]";
	}
	public HoaDon getHd() {
		return hd;
	}
	public void setHd(HoaDon hd) {
		this.hd = hd;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuongMua() {
		return soLuongMua;
	}

	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	public double tong() {
		return  sanPham.getGiaSP() *  soLuongMua;
	}
	
	
}
