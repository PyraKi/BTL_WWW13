package com.salamander.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "KhachHang")
public class KhachHang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String idKH;
	private String tenKH;
	private String sdt;
	private String email;
	private String gioiTinh;
	private String ngaySinh;
	private String diaChi;
	

	@OneToOne
	private TaiKhoan tk;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "kh")
	private List<HoaDon> dshd;
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public KhachHang(String idKH, String tenKH, String sdt, String email, String gioiTinh, String ngaySinh,
			String diaChi) {
		super();
		this.idKH = idKH;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
	}
	
	public TaiKhoan getTk() {
		return tk;
	}

	public void setTk(TaiKhoan tk) {
		this.tk = tk;
	}

	public String getIdKH() {
		return idKH;
	}
	public void setIdKH(String idKH) {
		this.idKH = idKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		return "KhachHang [idKH=" + idKH + ", tenKH=" + tenKH + ", sdt=" + sdt + ", email=" + email + ", gioiTinh="
				+ gioiTinh + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + "]";
	}
	
}
