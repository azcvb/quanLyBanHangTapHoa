package com.nhom2IT8.GSMW.service;

import java.util.List;

import com.nhom2IT8.GSMW.entity.NhaCungCap;

public interface NhaCungCapService {
	List<NhaCungCap> getNCC();
    List<NhaCungCap> searchNcc(String id, String tenNcc, String sdtNcc, String emailNcc, String diachiNcc);
    NhaCungCap saveNcc(NhaCungCap ncc);
    void delNcc(String id);
}
