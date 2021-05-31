package com.salamander.dao;

import java.util.List;

import com.salamander.entities.KhachHang;

public interface KhachHangDAO {
	public void addKH(KhachHang kh);
	public void updateKH(KhachHang kh);
	public List<KhachHang> listKHs();
	public KhachHang getKHById(long id);
	public void removeKH(long id);
	public KhachHang getKH(String value);
}
