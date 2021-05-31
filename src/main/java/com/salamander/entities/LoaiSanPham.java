package com.salamander.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LoaiSanPham")
public class LoaiSanPham implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long idLoaiSP;
	private String tenLoaiSP;
	
	@OneToMany(mappedBy = "loaisp", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SanPham> dssp;
	
	public LoaiSanPham() {
		// TODO Auto-generated constructor stub
	}

	public LoaiSanPham(long idLoaiSP, String tenLoaiSP) {
		super();
		this.idLoaiSP = idLoaiSP;
		this.tenLoaiSP = tenLoaiSP;
	}

	public long getIdLoaiSP() {
		return idLoaiSP;
	}

	public void setIdLoaiSP(long idLoaiSP) {
		this.idLoaiSP = idLoaiSP;
	}

	public String getTenLoaiSP() {
		return tenLoaiSP;
	}

	public void setTenLoaiSP(String tenLoaiSP) {
		this.tenLoaiSP = tenLoaiSP;
	}

	@Override
	public String toString() {
		return "LoaiSanPham [idLoaiSP=" + idLoaiSP + ", tenLoaiSP=" + tenLoaiSP + "]";
	}
	
}
