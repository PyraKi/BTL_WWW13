package com.salamander.service;

import java.util.List;

import com.salamander.entities.HoaDon;

public interface HoaDonService {
	public void addHD(HoaDon hd);
	public void updateHD(HoaDon hd);
	public List<HoaDon> listHDs();
	public HoaDon getHDById(long id);
	public void removeHD(long id);
}
