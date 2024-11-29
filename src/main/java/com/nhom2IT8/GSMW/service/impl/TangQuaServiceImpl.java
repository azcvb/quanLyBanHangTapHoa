package com.nhom2IT8.GSMW.service.impl;

import com.nhom2IT8.GSMW.entity.TangQua;
import com.nhom2IT8.GSMW.repository.TangQuaRepository;
import com.nhom2IT8.GSMW.service.TangQuaService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class TangQuaServiceImpl implements TangQuaService {
    private final TangQuaRepository tangQuaRepository;

    public TangQuaServiceImpl(TangQuaRepository tangQuaRepository) {
        this.tangQuaRepository = tangQuaRepository;
    }

    @Override
    public List<TangQua> getAll() {
        return tangQuaRepository.findAll();
    }

    @Override
    public void save(TangQua tangQua) {
        tangQuaRepository.save(tangQua);
    }

    @Override
    public TangQua getById(String id) {
        return tangQuaRepository.getById(id);
    }

    @Override
    public void update(TangQua tangQua) {
        TangQua exist = this.getById(tangQua.getTQ_id());
        exist.setTQ_SP_id(tangQua.getTQ_SP_id());
        exist.setTQ_tensanpham(tangQua.getTQ_tensanpham());
        exist.setTQ_dieukien(tangQua.getTQ_dieukien());
        exist.setTQ_SP_IDQuaTang(tangQua.getTQ_SP_IDQuaTang());
        exist.setTQ_soluongquatang(tangQua.getTQ_soluongquatang());
        if (Objects.nonNull(tangQua.getTQ_ngaybatdau())) {
            exist.setTQ_ngaybatdau(tangQua.getTQ_ngaybatdau());
        }
        if (Objects.nonNull(tangQua.getTQ_ngayketthuc())) {
            exist.setTQ_ngayketthuc(tangQua.getTQ_ngayketthuc());
        }
        exist.setTQ_mota(tangQua.getTQ_mota());
        tangQuaRepository.save(exist);
    }

    @Override
    public void delete(String id) {
        TangQua tangQua = this.getById(id);
        tangQuaRepository.delete(tangQua);
    }

    @Override
    public List<TangQua> search(String keyword) {
        return tangQuaRepository.search(keyword);
    }
}
