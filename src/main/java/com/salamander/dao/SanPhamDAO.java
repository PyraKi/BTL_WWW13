package com.salamander.dao;

import java.util.List;

import com.salamander.entities.SanPham;

public interface SanPhamDAO {
	public void addSanPham(SanPham sp);
	public void updateSanPham(SanPham sp);
	public List<SanPham> listSanPhams();
	public  List<SanPham> getPersonByIds(long id);
	public void removeSanPham(long id);
	public  SanPham getPersonById(long id);
	public  List<SanPham> search(String name);
}
