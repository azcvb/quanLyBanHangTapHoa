package com.nhom2IT8.GSMW.service.impl;

import com.nhom2IT8.GSMW.entity.SanPham;
import com.nhom2IT8.GSMW.repository.SanPhamRepository;
import com.nhom2IT8.GSMW.service.SanPhamService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SanPhamServiceImpl implements SanPhamService {
	private final SanPhamRepository sanPhamRepository;

	public SanPhamServiceImpl(SanPhamRepository sanPhamRepository) {
		this.sanPhamRepository = sanPhamRepository;
	}

	@Override
	public List<SanPham> getSanPhams() {
		return sanPhamRepository.GetSanPhams();
	}

	@Override
	public SanPham saveSanPham(SanPham sanpham) {
		return sanPhamRepository.save(sanpham);
	}

	@Override
	public SanPham getSanPhamById(String id) {
		Optional<SanPham> optionalSanPham = sanPhamRepository.findById(id);
		return optionalSanPham.orElseThrow(() -> new RuntimeException("Sản phẩm không tìm thấy với id: " + id));
	}

	@Override
	public SanPham updateSanPham(SanPham sanpham) {
		return sanPhamRepository.save(sanpham);
	}

	@Override
	public void deleteSanPhamById(String id) {
		sanPhamRepository.deleteById(id);
	}

	@Override
	public List<SanPham> searchSanPham(String id, String tensanpham, String loaisanpham, BigDecimal giaban, String mota,
			Integer soluong, Boolean trangthai) {
		return sanPhamRepository.findByCriteria(id, tensanpham, loaisanpham, giaban, mota, soluong, trangthai);

	}
	@Override
    public long countSanPham() {
        return sanPhamRepository.count();
    }

    @Override
    public BigDecimal sumTotalSanPham() {
        return sanPhamRepository.sumTotalQuantity();
    }

    @Override
    public void saveSanPham_T(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public Optional<SanPham> getSanPhamById_T(String id) {
        return sanPhamRepository.findById(id);
    }

    @Override
    public boolean existsById(String id) {
        return sanPhamRepository.existsById(id);
    }
}
