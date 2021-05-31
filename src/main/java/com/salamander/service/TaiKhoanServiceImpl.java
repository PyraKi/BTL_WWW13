package com.salamander.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salamander.dao.TaiKhoanDAO;
import com.salamander.entities.TaiKhoan;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService{
	
	@Autowired
	private TaiKhoanDAO tkDAO;

	

	@Override
	@Transactional
	public void addTK(TaiKhoan tk) {
		// TODO Auto-generated method stub
		this.tkDAO.addTK(tk);
	}

	@Override
	@Transactional
	public void updateTK(TaiKhoan tk) {
		// TODO Auto-generated method stub
		this.tkDAO.updateTK(tk);
	}

	@Override
	@Transactional
	public String checkTK(TaiKhoan tk) {
		// TODO Auto-generated method stub
		return this.tkDAO.checkTK(tk);
	}

	@Override
	@Transactional
	public TaiKhoan getTK(TaiKhoan tk) {
		// TODO Auto-generated method stub
		return this.tkDAO.getTK(tk);
	}

	@Override
	@Transactional
	public void removeTK(long id) {
		// TODO Auto-generated method stub
		this.tkDAO.removeTK(id);
	}
	
}	
