package com.poly.assignment.service;

import com.poly.assignment.entity.CuaHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {

    Page<CuaHang> findPaginated(Integer pageNo, Integer pageSize);

    void save(CuaHang ch);

    void delete(UUID id);

    CuaHang getOne(UUID id);

    List<CuaHang> getAll();
}
