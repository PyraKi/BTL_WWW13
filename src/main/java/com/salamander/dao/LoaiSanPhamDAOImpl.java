package com.salamander.dao;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.salamander.entities.LoaiSanPham;
import com.salamander.entities.NhaCungCap;


@Repository
public class LoaiSanPhamDAOImpl implements LoaiSanPhamDAO{
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void addLSP(LoaiSanPham lsp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(lsp);
	}

	@Override
	public void updateLSP(LoaiSanPham lsp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(lsp);	
	}

	@Override
	public List<LoaiSanPham> listLSPs() {
		Session session = this.sessionFactory.getCurrentSession();
		List<LoaiSanPham> dssp = session.createQuery("from LoaiSanPham").list();
		return dssp;
	}

	@Override
	public LoaiSanPham getLSPById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		LoaiSanPham lsp = session.load(LoaiSanPham.class, new Long(id));	
		return lsp;
	}

	@Override
	public void removeLSP(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		LoaiSanPham lsp = session.load(LoaiSanPham.class, new Long(id));
		if(lsp != null) {
			session.delete(lsp);
		}
	}


	@Override
	public long listLSP(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query= session.createQuery("from LoaiSanPham where tenLoaiSP = :tenLoaiSP");
		query.setParameter("tenLoaiSP", name);
		LoaiSanPham lsp  = (LoaiSanPham) query.getSingleResult();
		return lsp.getIdLoaiSP();
	}

	

}
