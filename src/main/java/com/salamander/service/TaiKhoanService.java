package com.salamander.service;

import java.util.List;

import com.salamander.entities.TaiKhoan;

public interface TaiKhoanService {
	public void addTK(TaiKhoan tk);
	public void updateTK(TaiKhoan tk);
	public String checkTK(TaiKhoan tk);
	public TaiKhoan getTK(TaiKhoan tk);
	public void removeTK(long id);
}
