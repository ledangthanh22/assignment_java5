package com.poly.assignment.service;

import com.poly.assignment.entity.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    List<SanPham> getAll();

    Page<SanPham> findPaginated(Integer pageNo, Integer pageSize);

    void save(SanPham sp);

    void delete(UUID id);

    SanPham getOne(UUID id);
}
