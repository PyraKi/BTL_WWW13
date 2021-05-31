package com.salamander.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.salamander.entities.NhanVien;

@Repository
public class NhanVienDAOImpl implements NhanVienDAO{
	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public void addNV(NhanVien nv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(nv);
	}

	@Override
	public void updateNV(NhanVien nv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(nv);	
	}

	@Override
	public List<NhanVien> listNVs() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<NhanVien> dssp = session.createQuery("from NhanVien").list();
		return dssp;
	}

	@Override
	public NhanVien getNVById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		NhanVien nv = session.load(NhanVien.class, new Float(id));	
		return nv;
	}

	@Override
	public void removeNV(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		NhanVien nv = session.load(NhanVien.class, new Float(id));
		if(nv != null) {
			session.delete(nv);
		}
	}

}
