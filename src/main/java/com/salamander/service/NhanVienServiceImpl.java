package com.salamander.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salamander.dao.NhanVienDAO;
import com.salamander.entities.NhanVien;

@Service
public class NhanVienServiceImpl implements NhanVienService{
	
	@Autowired
	private NhanVienDAO nvDAO;

	

	@Override
	@Transactional
	public void addNV(NhanVien nv) {
		// TODO Auto-generated method stub
		this.nvDAO.addNV(nv);
	}

	@Override
	@Transactional
	public void updateNV(NhanVien nv) {
		// TODO Auto-generated method stub
		this.nvDAO.updateNV(nv);
	}

	@Override
	@Transactional
	public List<NhanVien> listNVs() {
		// TODO Auto-generated method stub
		return this.nvDAO.listNVs();
	}

	@Override
	@Transactional
	public NhanVien getNVById(long id) {
		// TODO Auto-generated method stub
		return this.nvDAO.getNVById(id);
	}

	@Override
	@Transactional
	public void removeNV(long id) {
		// TODO Auto-generated method stub
		this.nvDAO.removeNV(id);
	}
	
}
