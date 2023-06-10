package com.poly.assignment.service;

import com.poly.assignment.entity.ThuongHieu;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface ThuongHieuService {

    List<ThuongHieu> getAll();

    Page<ThuongHieu> findPaginated(Integer pageNo, Integer pageSize);

    void save(ThuongHieu th);

    void delete(UUID id);

    ThuongHieu getOne(UUID id);
}
