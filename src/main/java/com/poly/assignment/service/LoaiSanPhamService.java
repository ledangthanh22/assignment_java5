package com.poly.assignment.service;

import com.poly.assignment.entity.LoaiSanPham;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface LoaiSanPhamService {

    List<LoaiSanPham> getAll();

    Page<LoaiSanPham> findPaginated(Integer pageNo, Integer pageSize);

    void save(LoaiSanPham lsp);

    void delete(UUID id);

    LoaiSanPham getOne(UUID id);
}
