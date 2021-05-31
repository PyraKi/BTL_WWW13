package com.salamander.bean;

import java.util.Date;

import com.salamander.entities.TaiKhoan;

public class LoginUser {
	private TaiKhoan tk;
	private Date lastLogin;
	public LoginUser() {
		// TODO Auto-generated constructor stub
	}
	public LoginUser(TaiKhoan tk) {
		super();
		this.tk = tk;
	}
	public TaiKhoan getTk() {
		return tk;
	}
	public void setTk(TaiKhoan tk) {
		this.tk = tk;
	}
	public TaiKhoan getTaiKhoanInfo() {
		if(lastLogin != null) {
			TaiKhoan temp = new TaiKhoan();
			temp.setTaiKhoan(tk.getTaiKhoan());
			return temp;
		}
		else
			return null;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	@Override
	public String toString() {
		return "LoginUser [tk=" + tk + ", lastLogin=" + lastLogin + "]";
	}
	
}
