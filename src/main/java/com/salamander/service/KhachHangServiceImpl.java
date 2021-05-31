package com.salamander.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salamander.dao.KhachHangDAO;
import com.salamander.entities.KhachHang;

@Service
public class KhachHangServiceImpl implements KhachHangService{
	@Autowired
	private KhachHangDAO khDAO;
	
	
	public void setKhDAO(KhachHangDAO khDAO) {
		this.khDAO = khDAO;
	}

	@Override
	@Transactional
	public void addKH(KhachHang kh) {
		this.khDAO.addKH(kh);
		
	}

	@Override
	@Transactional
	public void updateKH(KhachHang kh) {
		this.khDAO.updateKH(kh);
		
	}

	@Override
	@Transactional
	public List<KhachHang> listKHs() {
		// TODO Auto-generated method stub
		return this.khDAO.listKHs();
	}

	@Override
	@Transactional
	public KhachHang getKHById(long id) {
		// TODO Auto-generated method stub
		return this.khDAO.getKHById(id);
	}

	@Override
	@Transactional
	public void removeKH(long id) {
		this.khDAO.removeKH(id);
		
	}

	@Override
	@Transactional
	public KhachHang getKH(String value) {
		return this.khDAO.getKH(value);
	}
	
}
