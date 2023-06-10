package com.poly.assignment.service.impl;

import com.poly.assignment.entity.NhanVien;
import com.poly.assignment.repository.NhanVienRepository;
import com.poly.assignment.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public Page<NhanVien> findPaginated(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return nhanVienRepository.findAll(pageable);
    }

    @Override
    public void save(NhanVien nv) {
        nhanVienRepository.save(nv);
    }

    @Override
    public void delete(UUID id) {
        nhanVienRepository.deleteById(id);
    }

    @Override
    public NhanVien getOne(UUID id) {
        Optional<NhanVien> result = nhanVienRepository.findById(id);
        NhanVien nhanVien = null;
        if (result.isPresent()) {
            nhanVien = result.get();
        } else {
            throw new RuntimeException("Khong tim thay id: " + id);
        }
        return nhanVien;
    }
}
