package com.salamander.dao;

import java.util.List;

import com.salamander.entities.ChiTietHoaDon;



public interface ChiTietHoaDonDAO {
	public void addCTHD(ChiTietHoaDon cthd);
	public void updateCTHD(ChiTietHoaDon cthd);
	public List<ChiTietHoaDon> listCTHDs();
	public ChiTietHoaDon getCTHDById(long id);
	public void removeCTHD(long id);
}
