package com.salamander.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salamander.dao.SanPhamDAO;
import com.salamander.entities.SanPham;

@Service
public class SanPhamServiceImpl implements SanPhamService{
	
	@Autowired
	private SanPhamDAO sanPhamDAO;



	@Override
	@Transactional
	public void addSanPham(SanPham sp) { 
		this.sanPhamDAO.addSanPham(sp);
		
	}

	@Override
	@Transactional
	public void updateSanPham(SanPham sp) {
	this.sanPhamDAO.updateSanPham(sp);
		
	}

	@Override
	@Transactional
	public List<SanPham> listSanPhams() {
		
		return this.sanPhamDAO.listSanPhams();
	}

	@Override
	@Transactional
	public  List<SanPham> getPersonByIds(long id) {
		return this.sanPhamDAO.getPersonByIds(id);
	}
	
	@Override
	@Transactional
	public void removeSanPham(long id) {
		this.sanPhamDAO.removeSanPham(id);
		
	}
	
	@Override
	@Transactional
	public SanPham getPersonById(long id) {
		return this.sanPhamDAO.getPersonById(id);
	}

	@Override
	@Transactional
	public List<SanPham>  search(String name) {
		return this.sanPhamDAO.search(name);
	}
	
	
}
