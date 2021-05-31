package com.salamander.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salamander.dao.LoaiSanPhamDAO;
import com.salamander.entities.LoaiSanPham;

@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService{
	@Autowired
	private LoaiSanPhamDAO lspDAO;


	@Override
	@Transactional
	public void addLSP(LoaiSanPham lsp) {
		// TODO Auto-generated method stub
		this.lspDAO.addLSP(lsp);
	}

	@Override
	@Transactional
	public void updateLSP(LoaiSanPham lsp) {
		// TODO Auto-generated method stub
		this.lspDAO.updateLSP(lsp);
	}

	@Override
	@Transactional
	public List<LoaiSanPham> listLSPs() {
		// TODO Auto-generated method stub
		return this.lspDAO.listLSPs();
	}

	@Override
	@Transactional
	public LoaiSanPham getLSPById(long id) {
		// TODO Auto-generated method stub
		return this.lspDAO.getLSPById(id);
	}

	@Override
	@Transactional
	public void removeLSP(long id) {
		// TODO Auto-generated method stub
		this.lspDAO.removeLSP(id);
	}

	@Override
	@Transactional
	public long listLSP(String name) {
		
		return this.lspDAO.listLSP(name);
	}

	
}
