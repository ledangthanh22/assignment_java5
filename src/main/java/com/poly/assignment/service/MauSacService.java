package com.poly.assignment.service;

import com.poly.assignment.entity.MauSac;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface MauSacService {

    List<MauSac> getAll();

    Page<MauSac> findPaginated(Integer pageNo, Integer pageSize);

    void save(MauSac ms);

    void delete(UUID id);

    MauSac getOne(UUID id);
}
