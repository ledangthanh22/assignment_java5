package com.poly.assignment.service.impl;

import com.poly.assignment.entity.MauSac;
import com.poly.assignment.repository.MauSacRepository;
import com.poly.assignment.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.findAll();
    }

    @Override
    public Page<MauSac> findPaginated(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return mauSacRepository.findAll(pageable);
    }

    @Override
    public void save(MauSac ms) {
        mauSacRepository.save(ms);
    }

    @Override
    public void delete(UUID id) {
        mauSacRepository.deleteById(id);
    }

    @Override
    public MauSac getOne(UUID id) {
        Optional<MauSac> result = mauSacRepository.findById(id);
        MauSac mauSac = null;
        if (result.isPresent()) {
            mauSac = result.get();
        } else {
            throw new RuntimeException("Khong tim thay id: " + id);
        }
        return mauSac;
    }
}
