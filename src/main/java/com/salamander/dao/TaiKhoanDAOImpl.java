package com.salamander.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.salamander.entities.ChiTietHoaDon;
import com.salamander.entities.TaiKhoan;

@Repository
public class TaiKhoanDAOImpl implements TaiKhoanDAO{

	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void addTK(TaiKhoan tk) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(tk);
	}

	@Override
	public void updateTK(TaiKhoan tk) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(tk);	
	}

	@Override
	public String checkTK(TaiKhoan tk) {
		Session session = this.sessionFactory.getCurrentSession();
		 Query query = session.createQuery("from TaiKhoan  where taiKhoan =:taiKhoan ");
		 query.setParameter("taiKhoan", tk.getTaiKhoan());
		List<TaiKhoan> dssp = query.list();
		return dssp.size() > 0 ? dssp.get(0).getQuyenHan() : null ;
	}

	@Override
	@SuppressWarnings("unchecked")
	public TaiKhoan getTK (TaiKhoan tk) {
		/*
		 * Session session = this.sessionFactory.getCurrentSession(); String sql =
		 * " from TaiKhoan tk where tk.taiKhoan= :tkhoan.username and tk.matKhau =:tkhoan.pass "
		 * ; Query query = session.createQuery(sql);
		 * query.setParameter("tkhoan.username", tk.getTaiKhoan());
		 * query.setParameter("tkhoan.pass", tk.getMatKhau()); List<TaiKhoan> dstk =
		 * query.list();
		 */
		Session session = this.sessionFactory.getCurrentSession();
		
		List<TaiKhoan> dssp = (List<TaiKhoan>) session.createQuery("from TaiKhoan").list();
		
		for(TaiKhoan tk1 : dssp) {
			if(tk1.getTaiKhoan().equalsIgnoreCase(tk.getTaiKhoan()) && tk1.getMatKhau().equalsIgnoreCase(tk.getMatKhau())) {
				tk = tk1;
				return tk;
			}
		}
		tk.setQuyenHan("");
		return tk;
	}

	@Override
	public void removeTK(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		TaiKhoan tk = session.load(TaiKhoan.class, new Float(id));
		if(tk != null) {
			session.delete(tk);
		}
	}

}
