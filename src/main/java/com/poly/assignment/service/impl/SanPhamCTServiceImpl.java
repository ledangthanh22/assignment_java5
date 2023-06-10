package com.poly.assignment.service.impl;

import com.poly.assignment.entity.SanPhamCT;
import com.poly.assignment.repository.SanPhamCTRepository;
import com.poly.assignment.service.SanPhamCTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SanPhamCTServiceImpl implements SanPhamCTService {

    @Autowired
    private SanPhamCTRepository sanPhamCTRepository;

    @Override
    public Page<SanPhamCT> findPaginated(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return sanPhamCTRepository.findAll(pageable);
    }

    @Override
    public void save(SanPhamCT spct) {
       sanPhamCTRepository.save(spct);
    }

    @Override
    public void delete(UUID id) {
         sanPhamCTRepository.deleteById(id);
    }

    @Override
    public SanPhamCT getOne(UUID id) {
        Optional<SanPhamCT> result = sanPhamCTRepository.findById(id);
        SanPhamCT sanPhamCT = null;
        if (result.isPresent()){
            sanPhamCT = result.get();
        }else {
            throw new RuntimeException("Khong tim thay id: "+id);
        }
        return sanPhamCT;
    }
}
