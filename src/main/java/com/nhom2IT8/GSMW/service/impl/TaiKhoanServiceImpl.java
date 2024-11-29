package com.nhom2IT8.GSMW.service.impl;

import com.nhom2IT8.GSMW.entity.TaiKhoan;
import com.nhom2IT8.GSMW.repository.TaiKhoanRepository;
import com.nhom2IT8.GSMW.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public TaiKhoan findByUsernameAndPassword(String username, String password) {
        return taiKhoanRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public TaiKhoan getById(Integer id) {
        return taiKhoanRepository.getById(id);
    }




}
