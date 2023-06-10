package com.poly.assignment.service;

import com.poly.assignment.entity.ChucVu;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {

    Page<ChucVu> findPaginated(Integer pageNo, Integer pageSize);

    void save(ChucVu cv);

    void delete(UUID id);

    ChucVu getOne(UUID id);

    List<ChucVu> getAll();
}
