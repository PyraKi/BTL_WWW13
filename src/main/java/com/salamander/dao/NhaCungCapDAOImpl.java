package com.salamander.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.salamander.entities.NhaCungCap;

@Repository
public class NhaCungCapDAOImpl implements NhaCungCapDAO{
	@Autowired
	private SessionFactory sessionFactory;

	


	@Override
	public void addNCC(NhaCungCap ncc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(ncc);
	}

	@Override
	public void updateNCC(NhaCungCap ncc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(ncc);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NhaCungCap> listNCCs() {
		Session session = this.sessionFactory.getCurrentSession();
		List<NhaCungCap> dssp = session.createQuery("from NhaCungCap").list();
		return dssp;
	}

	@Override
	public NhaCungCap getNCCById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		NhaCungCap ncc = session.load(NhaCungCap.class, new Float(id));	
		return ncc;
	}

	@Override
	public void removeNCC(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		NhaCungCap ncc = session.load(NhaCungCap.class, new Long(id));
		if(ncc != null) {
			session.delete(ncc);
		}
	}

}
