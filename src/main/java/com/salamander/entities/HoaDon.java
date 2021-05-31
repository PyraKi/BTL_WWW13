package com.salamander.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="HoaDon")
public class HoaDon implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long idMaHD;
	private LocalDateTime ngayLapHoaDon;
	@ManyToOne
	@JoinColumn(name = "kh_id" , nullable = false )
	private KhachHang kh;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "hd")
	private List<ChiTietHoaDon> dsCTHD;	
	public HoaDon() {
		// TODO Auto-generated constructor stub
	}

	

	public HoaDon(long idMaHD, LocalDateTime ngayLapHoaDon, KhachHang kh) {
		super();
		this.idMaHD = idMaHD;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.kh = kh;
	}



	public long getIdMaHD() {
		return idMaHD;
	}

	public void setIdMaHD(long idMaHD) {
		this.idMaHD = idMaHD;
	}

	
	
	public KhachHang getKh() {
		return kh;
	}

	public void setKh(KhachHang kh) {
		this.kh = kh;
	}

	public List<ChiTietHoaDon> getDsCTHD() {
		return dsCTHD;
	}

	public void setDsCTHD(List<ChiTietHoaDon> dsCTHD) {
		this.dsCTHD = dsCTHD;
	}



	@Override
	public String toString() {
		return "HoaDon [idMaHD=" + idMaHD + ", ngayLapHoaDon=" + ngayLapHoaDon + ", kh=" + kh + ", dsCTHD=" + dsCTHD
				+ "]";
	}



	public LocalDateTime getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}



	public void setNgayLapHoaDon(LocalDateTime ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	
	
	
}
