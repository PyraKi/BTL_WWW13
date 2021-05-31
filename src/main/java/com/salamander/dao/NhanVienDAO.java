package com.salamander.dao;

import java.util.List;

import com.salamander.entities.NhanVien;



public interface NhanVienDAO {
	public void addNV(NhanVien nv);
	public void updateNV(NhanVien nv);
	public List<NhanVien> listNVs();
	public NhanVien getNVById(long id);
	public void removeNV(long id);
}
