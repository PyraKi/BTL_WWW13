package com.salamander.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salamander.dao.ChiTietHoaDonDAO;
import com.salamander.entities.ChiTietHoaDon;

@Service
public class ChiTietHoaDonServiceImpl implements ChiTietHoaDonService{
	@Autowired
	private ChiTietHoaDonDAO CTHDDAO;
	
	

	@Override
	@Transactional
	public void addCTHD(ChiTietHoaDon cthd) {
		this.CTHDDAO.addCTHD(cthd);
	}

	@Override
	@Transactional
	public void updateCTHD(ChiTietHoaDon cthd) {
		this.CTHDDAO.updateCTHD(cthd);
		
	}

	@Override
	@Transactional
	public List<ChiTietHoaDon> listCTHDs() {
		return this.CTHDDAO.listCTHDs();
	}

	@Override
	@Transactional
	public ChiTietHoaDon getCTHDById(long id) {
		
		return this.CTHDDAO.getCTHDById(id);
	}

	@Override
	@Transactional
	public void removeCTHD(long id) {
		this.CTHDDAO.removeCTHD(id);
		
	}

}
