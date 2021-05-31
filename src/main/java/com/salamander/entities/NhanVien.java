package com.salamander.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "NhanVien")
public class NhanVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String idNV;
	private String tenNV;
	private String sdt;
	private String gioiTinh;
	private String email;
	private String diaChi;
	
	@OneToOne
	private TaiKhoan tk;
	public NhanVien() {
		// TODO Auto-generated constructor stub
	}
	public NhanVien(String idNV, String tenNV, String sdt, String gioiTinh, String email, String diaChi) {
		super();
		this.idNV = idNV;
		this.tenNV = tenNV;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.diaChi = diaChi;
	}
	
	public TaiKhoan getTk() {
		return tk;
	}
	public void setTk(TaiKhoan tk) {
		this.tk = tk;
	}
	public String getIdNV() {
		return idNV;
	}
	public void setIdNV(String idNV) {
		this.idNV = idNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		return "NhanVien [idNV=" + idNV + ", tenNV=" + tenNV + ", sdt=" + sdt + ", gioiTinh=" + gioiTinh + ", email="
				+ email + ", diaChi=" + diaChi + "]";
	}
	
}
