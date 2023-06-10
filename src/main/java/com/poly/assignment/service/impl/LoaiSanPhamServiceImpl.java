package com.poly.assignment.service.impl;

import com.poly.assignment.entity.LoaiSanPham;
import com.poly.assignment.repository.LoaiSanPhamRepostitory;
import com.poly.assignment.service.LoaiSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService {

    @Autowired
    private LoaiSanPhamRepostitory loaiSanPhamRepostitory;

    @Override
    public List<LoaiSanPham> getAll() {
        return loaiSanPhamRepostitory.findAll();
    }

    @Override
    public Page<LoaiSanPham> findPaginated(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return loaiSanPhamRepostitory.findAll(pageable);
    }

    @Override
    public void save(LoaiSanPham lsp) {
        loaiSanPhamRepostitory.save(lsp);
    }

    @Override
    public void delete(UUID id) {
        loaiSanPhamRepostitory.deleteById(id);
    }

    @Override
    public LoaiSanPham getOne(UUID id) {
        Optional<LoaiSanPham> result = loaiSanPhamRepostitory.findById(id);
        LoaiSanPham loaiSanPham = null;
        if (result.isPresent()){
            loaiSanPham = result.get();
        }else {
            throw new RuntimeException("khong tim thay id: " +id);
        }
        return loaiSanPham;
    }
}
