package com.salamander.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.salamander.entities.LoaiSanPham;


@Repository
public class MenuDAOImpl implements MenuDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<String> getTenlsp() {
			List<String> menus = new ArrayList<String>();
			Session session = this.sessionFactory.getCurrentSession();
			List<LoaiSanPham> dslsp = session.createQuery("from LoaiSanPham").list();
			for(LoaiSanPham lsp : dslsp) {
				menus.add(lsp.getTenLoaiSP());
			}
			menus.forEach(x->System.out.println(x));
			return menus;
		}
	}


