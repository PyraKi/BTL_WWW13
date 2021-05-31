package com.salamander.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.salamander.entities.ChiTietHoaDon;
@Repository
public class ChiTietHoaDonDAOImpl implements ChiTietHoaDonDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addCTHD(ChiTietHoaDon cthd) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(cthd);
	}

	@Override
	public void updateCTHD(ChiTietHoaDon cthd) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(cthd);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChiTietHoaDon> listCTHDs() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ChiTietHoaDon> dssp = session.createQuery("from ChiTietHoaDon").list();
		return dssp;
	}

	@Override
	public ChiTietHoaDon getCTHDById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		ChiTietHoaDon cthd = session.load(ChiTietHoaDon.class, new Float(id));	
		return cthd;
	}

	@Override
	public void removeCTHD(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		ChiTietHoaDon cthd = session.load(ChiTietHoaDon.class, new Float(id));
		if(cthd != null) {
			session.delete(cthd);
		}
	}

}
