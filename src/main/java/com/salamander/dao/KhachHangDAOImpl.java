package com.salamander.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.salamander.entities.KhachHang;


@Repository
public class KhachHangDAOImpl implements KhachHangDAO{
	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public void addKH(KhachHang kh) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(kh);
	}

	@Override
	public void updateKH(KhachHang kh) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(kh);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KhachHang> listKHs() {
		Session session = this.sessionFactory.getCurrentSession();
		List<KhachHang> dssp = session.createQuery("from KhachHang").list();
		return dssp;
	}

	@Override
	public KhachHang getKHById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		KhachHang kh = session.load(KhachHang.class, new Float(id));	
		return kh;
	}

	@Override
	public void removeKH(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		KhachHang kh = session.load(KhachHang.class, new Float(id));
		if(kh != null) {
			session.delete(kh);
		}
	}

	@Override
	public KhachHang getKH(String value) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query= session.createQuery("from KhachHang where tk_taiKhoan = :tk_taiKhoan");
		query.setParameter("tk_taiKhoan", value);
		KhachHang kh  = (KhachHang) query.getSingleResult();
		return kh;
	}

}
