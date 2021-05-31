package com.salamander.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="NhaCungCap")
public class NhaCungCap implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long idNCC;
	private String tenNCC;
	private String xuatXuNCC;
	
	@ManyToOne
	@JoinColumn(name = "sp_id")
	private SanPham sp;
	public NhaCungCap() {
		// TODO Auto-generated constructor stub
	}

	public NhaCungCap(long idNCC, String tenNCC, String xuatXuNCC) {
		super();
		this.idNCC = idNCC;
		this.tenNCC = tenNCC;
		this.xuatXuNCC = xuatXuNCC;
	}

	public long getIdNCC() {
		return idNCC;
	}
	
	public SanPham getSp() {
		return sp;
	}

	public void setSp(SanPham sp) {
		this.sp = sp;
	}

	public void setIdNCC(long idNCC) {
		this.idNCC = idNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getXuatXuNCC() {
		return xuatXuNCC;
	}

	public void setXuatXuNCC(String xuatXuNCC) {
		this.xuatXuNCC = xuatXuNCC;
	}

	@Override
	public String toString() {
		return "NhaCungCap [idNCC=" + idNCC + ", tenNCC=" + tenNCC + ", xuatXuNCC=" + xuatXuNCC + "]";
	}
	
}
