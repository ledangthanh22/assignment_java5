package com.poly.assignment.service;

import com.poly.assignment.entity.SanPhamCT;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface SanPhamCTService {

    Page<SanPhamCT> findPaginated(Integer pageNo, Integer pageSize);

    void save(SanPhamCT spct);

    void delete(UUID id);

    SanPhamCT getOne(UUID id);
}
