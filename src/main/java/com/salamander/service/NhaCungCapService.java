package com.salamander.service;

import java.util.List;

import com.salamander.entities.NhaCungCap;

public interface NhaCungCapService {
	public void addNCC(NhaCungCap ncc);
	public void updateNCC(NhaCungCap ncc);
	public List<NhaCungCap> listNCCs();
	public NhaCungCap getNCCById(long id);
	public void removeNCC(long id);
}
