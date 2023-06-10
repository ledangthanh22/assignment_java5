package com.poly.assignment.service.impl;

import com.poly.assignment.entity.SanPham;
import com.poly.assignment.repository.SanPhamRepository;
import com.poly.assignment.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public Page<SanPham> findPaginated(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return sanPhamRepository.findAll(pageable);
    }

    @Override
    public void save(SanPham sp) {
        sanPhamRepository.save(sp);
    }

    @Override
    public void delete(UUID id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public SanPham getOne(UUID id) {
        Optional<SanPham> result = sanPhamRepository.findById(id);
        SanPham sanPham = null;
        if (result.isPresent()) {
            sanPham = result.get();
        } else {
            throw new RuntimeException("Khong tim thay id: " + id);
        }
        return sanPham;
    }
}
