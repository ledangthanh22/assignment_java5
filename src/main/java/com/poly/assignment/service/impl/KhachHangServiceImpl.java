package com.poly.assignment.service.impl;

import com.poly.assignment.entity.KhachHang;
import com.poly.assignment.repository.KhachHangRepository;
import com.poly.assignment.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public Page<KhachHang> findPaginated(Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        return khachHangRepository.findAll(pageable);
    }

    @Override
    public void save(KhachHang kh) {
        khachHangRepository.save(kh);
    }

    @Override
    public void delete(UUID id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public KhachHang getOne(UUID id) {
        Optional<KhachHang> result = khachHangRepository.findById(id);
        KhachHang khachHang = null;
        if (result.isPresent()){
            khachHang = result.get();
        }else {
            throw new RuntimeException("Khong tim thay id"+id);
        }
        return khachHang;
    }
}
