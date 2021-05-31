package com.salamander.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salamander.dao.HoaDonDAO;
import com.salamander.entities.HoaDon;

@Service
public class HoaDonServiceImpl implements HoaDonService{
	@Autowired
	private HoaDonDAO hdDAO;

	

	@Override
	@Transactional
	public void addHD(HoaDon hd) {
		this.hdDAO.addHD(hd);
		
	}

	@Override
	@Transactional
	public void updateHD(HoaDon hd) {
		this.hdDAO.updateHD(hd);
	}

	@Override
	@Transactional
	public List<HoaDon> listHDs() {
		
		return this.hdDAO.listHDs();
	}

	@Override
	@Transactional
	public HoaDon getHDById(long id) {
		// TODO Auto-generated method stub
		return this.hdDAO.getHDById(id);
	}

	@Override
	@Transactional
	public void removeHD(long id) {
		this.hdDAO.removeHD(id);
		
		
	}

}
