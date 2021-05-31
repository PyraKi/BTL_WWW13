package com.salamander.dao;

import java.util.List;

import com.salamander.entities.TaiKhoan;



public interface TaiKhoanDAO {
	public void addTK(TaiKhoan tk);
	public void updateTK(TaiKhoan tk);
	public String checkTK(TaiKhoan tk);
	public TaiKhoan getTK(TaiKhoan tk);
	public void removeTK(long id);
}
