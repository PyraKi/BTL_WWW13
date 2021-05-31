package com.salamander.dao;

import java.util.List;

import com.salamander.entities.LoaiSanPham;



public interface LoaiSanPhamDAO {
	public void addLSP(LoaiSanPham lsp);
	public void updateLSP(LoaiSanPham lsp);
	public List<LoaiSanPham> listLSPs();
	public LoaiSanPham getLSPById(long id);
	public void removeLSP(long id);
	public long listLSP(String name);
}
