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
@Table(name = "TaiKhoan")
public class TaiKhoan implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String taiKhoan;
	private String matKhau;
	private String quyenHan;
	@OneToOne
	@JoinColumn
	@PrimaryKeyJoinColumn
	private NhanVien nv;
	

	@OneToOne
	@JoinColumn
	@PrimaryKeyJoinColumn
	private KhachHang kh;
	public TaiKhoan() {
		// TODO Auto-generated constructor stub
	}
	
	public TaiKhoan(String taiKhoan, String matKhau) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}

	public TaiKhoan( String taiKhoan, String matKhau, String quyenHan) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.quyenHan = quyenHan;
	}
	

//	public NhanVien getNv() {
//		return nv;
//	}
//
//	public void setNv(NhanVien nv) {
//		this.nv = nv;
//	}

	public KhachHang getKh() {
		return kh;
	}

	public void setKh(KhachHang kh) {
		this.kh = kh;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getQuyenHan() {
		return quyenHan;
	}
	public void setQuyenHan(String quyenHan) {
		this.quyenHan = quyenHan;
	}
	
	@Override
	public String toString() {
		return "TaiKhoan [taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", quyenHan=" + quyenHan + "]";
	}
	
}
