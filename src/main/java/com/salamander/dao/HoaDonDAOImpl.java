package com.salamander.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.salamander.entities.HoaDon;

@Repository
public class HoaDonDAOImpl implements HoaDonDAO{
	@Autowired
private SessionFactory sessionFactory;
	
	
	@Override
	public void addHD(HoaDon hd) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(hd);	
	}

	@Override
	public void updateHD(HoaDon hd) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(hd);	
	}

	@Override
	public List<HoaDon> listHDs() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<HoaDon> dssp = session.createQuery("from HoaDon").list();
		return dssp;
	}

	@Override
	public HoaDon getHDById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		HoaDon hd = session.load(HoaDon.class, new Float(id));	
		return hd;
	}

	@Override
	public void removeHD(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		HoaDon hd = session.load(HoaDon.class, new Float(id));
		if(hd != null) {
			session.delete(hd);
		}
	}

}
