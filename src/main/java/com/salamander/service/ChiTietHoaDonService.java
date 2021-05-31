package com.salamander.service;

import java.util.List;

import com.salamander.entities.ChiTietHoaDon;


public interface ChiTietHoaDonService {
	public void addCTHD(ChiTietHoaDon cthd);
	public void updateCTHD(ChiTietHoaDon cthd);
	public List<ChiTietHoaDon> listCTHDs();
	public ChiTietHoaDon getCTHDById(long id);
	public void removeCTHD(long id);
}
