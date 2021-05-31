package com.salamander.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.salamander.entities.SanPham;

@Repository
public class SanPhamDAOImpl implements SanPhamDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	

	@Override
	public void addSanPham(SanPham sp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(sp);	
	}

	@Override
	public void updateSanPham(SanPham sp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(sp);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SanPham> listSanPhams() {
		Session session = this.sessionFactory.getCurrentSession();
		List<SanPham> dssp = session.createQuery("from SanPham").list();
		return dssp;
	}

	@Override
	public  List<SanPham> getPersonByIds(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query  = session.createQuery("from SanPham where id_LoaiSP = :LoaiSP");
		query.setParameter("LoaiSP", id);
		List<SanPham> dssp = query.list();
		return dssp;
	}

	@Override
	public void removeSanPham(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		SanPham sp = session.load(SanPham.class, new Long(id));
		if(sp != null) {
			session.delete(sp);
		}
	}

	@Override
	public SanPham getPersonById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query= session.createQuery("from SanPham where idSP = :idSP");
		query.setParameter("idSP", id);
		SanPham sp  = (SanPham) query.getSingleResult();
		return sp;
	}

	@Override
	public List<SanPham> search(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query= session.createQuery("from SanPham where tenSP = :tenSP");
		query.setParameter("tenSP", name);
		List<SanPham> dssp = query.list();
		return dssp;
	}

	
	
}
