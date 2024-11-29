package com.nhom2IT8.GSMW.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom2IT8.GSMW.entity.NhaCungCap;
import com.nhom2IT8.GSMW.repository.NhaCungCapRepository;
import com.nhom2IT8.GSMW.service.NhaCungCapService;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {

	@Autowired
	private NhaCungCapRepository nccRepo;

	@Override
	public List<NhaCungCap> getNCC() {
		return nccRepo.getNCC();
	}

	@Override
	public List<NhaCungCap> searchNcc(String id, String tenNcc, String sdtNcc, String emailNcc, String diachiNcc) {
		return nccRepo.searchNCC(id, tenNcc, sdtNcc, emailNcc, diachiNcc);
	}

	@Override
	public NhaCungCap saveNcc(NhaCungCap ncc) {
		return nccRepo.save(ncc);
	}

	@Override
	public void delNcc(String id) {
		nccRepo.deleteById(id);

	}

}
