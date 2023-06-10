package com.poly.assignment.service;

import com.poly.assignment.entity.KhachHang;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface KhachHangService {

    Page<KhachHang> findPaginated(Integer pageNo, Integer pageSize);

    void save(KhachHang kh);

    void delete(UUID id);

    KhachHang getOne(UUID id);
}
