package com.salamander.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salamander.dao.MenuDAO;
@Service
public class MenuserviceImpl implements MenuService{
	@Autowired
	public MenuDAO menudao;
	@Override
	@Transactional
	public List<String> getTenlsp() {
		
		return this.menudao.getTenlsp();
	}

}
