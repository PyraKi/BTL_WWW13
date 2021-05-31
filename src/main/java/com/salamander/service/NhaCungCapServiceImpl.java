package com.salamander.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salamander.dao.NhaCungCapDAO;
import com.salamander.entities.NhaCungCap;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService{
	@Autowired
	private NhaCungCapDAO nccDAO;

	

	@Override
	@Transactional
	public void addNCC(NhaCungCap ncc) {
		// TODO Auto-generated method stub
		this.nccDAO.addNCC(ncc);
	}

	@Override
	@Transactional
	public void updateNCC(NhaCungCap ncc) {
		// TODO Auto-generated method stub
		this.nccDAO.updateNCC(ncc);
	}

	@Override
	@Transactional
	public List<NhaCungCap> listNCCs() {
		// TODO Auto-generated method stub
		return this.nccDAO.listNCCs();
	}

	@Override
	@Transactional
	public NhaCungCap getNCCById(long id) {
		// TODO Auto-generated method stub
		return this.nccDAO.getNCCById(id);
	}

	@Override
	@Transactional
	public void removeNCC(long id) {
		// TODO Auto-generated method stub
		this.nccDAO.removeNCC(id);
	}
	
}
