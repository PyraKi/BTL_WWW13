package com.salamander.service;

import java.util.List;

import com.salamander.entities.NhanVien;

public interface NhanVienService {
	public void addNV(NhanVien nv);
	public void updateNV(NhanVien nv);
	public List<NhanVien> listNVs();
	public NhanVien getNVById(long id);
	public void removeNV(long id);
}
