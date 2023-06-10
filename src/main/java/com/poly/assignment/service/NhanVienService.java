package com.poly.assignment.service;

import com.poly.assignment.entity.NhanVien;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface NhanVienService {

    Page<NhanVien> findPaginated(Integer pageNo, Integer pageSize);

    void save(NhanVien nv);

    void delete(UUID id);

    NhanVien getOne(UUID id);
}
