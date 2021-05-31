package com.salamander.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "SanPham")
public class SanPham implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long idSP;
	private String tenSP;
	private int soLuong;
	private float giaSP;
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date namSXSP;
	private String moTa;
	private String thongSoKiThuat;
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date thoiGianBaoHanh;
	private String url;
	
	@OneToMany(mappedBy = "sanPham" , cascade = CascadeType.ALL)
	private List<ChiTietHoaDon> dsCTHD;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_LoaiSP" , nullable = false,foreignKey = @ForeignKey)
	private LoaiSanPham loaisp;
	
	@OneToMany(mappedBy = "sp",fetch = FetchType.LAZY)
	private List<NhaCungCap> dsNCC;
	
	public SanPham() {
		// TODO Auto-generated constructor stub
	}

	public SanPham(long idSP, String tenSP, int soLuong, float giaSP, Date namSXSP, String moTa, String thongSoKiThuat,
			Date thoiGianBaoHanh, String url) {
		super();
		this.idSP = idSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.giaSP = giaSP;
		this.namSXSP = namSXSP;
		this.moTa = moTa;
		this.thongSoKiThuat = thongSoKiThuat;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.url = url;
	}
	
	public LoaiSanPham getLoaisp() {
		return loaisp;
	}

	public void setLoaisp(LoaiSanPham loaisp) {
		this.loaisp = loaisp;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getIdSP() {
		return idSP;
	}

	public void setIdSP(long idSP) {
		this.idSP = idSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getGiaSP() {
		return giaSP;
	}

	public void setGiaSP(float giaSP) {
		this.giaSP = giaSP;
	}



	public Date getNamSXSP() {
		return namSXSP;
	}



	public void setNamSXSP(Date namSXSP) {
		this.namSXSP = namSXSP;
	}



	public String getMoTa() {
		return moTa;
	}



	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}



	public String getThongSoKiThuat() {
		return thongSoKiThuat;
	}



	public void setThongSoKiThuat(String thongSoKiThuat) {
		this.thongSoKiThuat = thongSoKiThuat;
	}



	public Date getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}



	public void setThoiGianBaoHanh(Date thoiGianBaoHanh) {
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}



	@Override
	public String toString() {
		return "SanPham [idSP=" + idSP + ", tenSP=" + tenSP + ", soLuong=" + soLuong + ", giaSP=" + giaSP + ", namSXSP="
				+ namSXSP + ", moTa=" + moTa + ", thongSoKiThuat=" + thongSoKiThuat + ", thoiGianBaoHanh="
				+ thoiGianBaoHanh + "]";
	}


}
