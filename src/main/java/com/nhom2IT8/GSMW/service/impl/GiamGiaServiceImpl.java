package com.nhom2IT8.GSMW.service.impl;

import com.nhom2IT8.GSMW.entity.GiamGia;
import com.nhom2IT8.GSMW.repository.GiamGiaRepository;
import com.nhom2IT8.GSMW.repository.SanPhamRepository;
import com.nhom2IT8.GSMW.service.GiamGiaService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

@Component
@Transactional
public class GiamGiaServiceImpl implements GiamGiaService {
    private final GiamGiaRepository giamGiaRepository;
    private final SanPhamRepository sanPhamRepository;

    public GiamGiaServiceImpl(GiamGiaRepository giamGiaRepository,
                              SanPhamRepository sanPhamRepository) {
        this.giamGiaRepository = giamGiaRepository;
        this.sanPhamRepository = sanPhamRepository;
    }

    @Override
    public List<GiamGia> getAll() {
        return giamGiaRepository.findAll();
    }

    @Override
    public void createOrUpdate(GiamGia giamGia) {
        GiamGia exist = giamGiaRepository.findByProductId(giamGia.getGG_SP_id());
        if (Objects.isNull(exist)) {
            giamGiaRepository.save(giamGia);
            sanPhamRepository.findById(giamGia.getGG_SP_id())
                    .ifPresent(item -> {
                        sanPhamRepository.update(item.getSP_id(),
                                item.getSP_TenSanPham(),
                                item.getSP_LoaiSanPham(),
                                item.getSP_GiaBan()
                                        .multiply(BigDecimal.valueOf(1 - giamGia.getGG_chietkhau())),
                                item.getSP_MoTa(),
                                item.getSP_SoLuong());
                    });
        } else {
            Double chietKhau = exist.getGG_chietkhau();
            exist.setGG_tensanpham(giamGia.getGG_tensanpham());
            exist.setGG_chietkhau(giamGia.getGG_chietkhau());
            if (Objects.nonNull(giamGia.getGG_ngaybatdau())) {
                exist.setGG_ngaybatdau(giamGia.getGG_ngaybatdau());
            }
            if (Objects.nonNull(giamGia.getGG_ngayketthuc())) {
                exist.setGG_ngayketthuc(giamGia.getGG_ngayketthuc());
            }
            exist.setGG_mota(giamGia.getGG_mota());
            giamGiaRepository.save(exist);
            sanPhamRepository.findById(exist.getGG_SP_id())
                    .ifPresent(item -> {
                        BigDecimal giaCu = item.getSP_GiaBan().divide(BigDecimal.valueOf(1 - chietKhau), RoundingMode.HALF_UP);
                        sanPhamRepository.update(item.getSP_id(),
                                item.getSP_TenSanPham(),
                                item.getSP_LoaiSanPham(),
                                giaCu.multiply(BigDecimal.valueOf(1 - exist.getGG_chietkhau())),
                                item.getSP_MoTa(),
                                item.getSP_SoLuong());
                    });
        }
    }


    @Override
    public GiamGia getById(String id) {
        return giamGiaRepository.getById(id);
    }

    @Override
    public List<GiamGia> search(String keyword) {
        return giamGiaRepository.search(keyword);
    }
}
