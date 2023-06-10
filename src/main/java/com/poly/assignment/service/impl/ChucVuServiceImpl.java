package com.poly.assignment.service.impl;

import com.poly.assignment.entity.ChucVu;
import com.poly.assignment.repository.ChucVuRepository;
import com.poly.assignment.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {

    @Autowired
    private ChucVuRepository chucVuRepository;


    @Override
    public Page<ChucVu> findPaginated(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return chucVuRepository.findAll(pageable);
    }

    @Override
    public void save(ChucVu cv) {
         chucVuRepository.save(cv);
    }

    @Override
    public void delete(UUID id) {
       chucVuRepository.deleteById(id);
    }

    @Override
    public ChucVu getOne(UUID id) {
        Optional<ChucVu> result = chucVuRepository.findById(id);
        ChucVu chucVu = null;
        if (result.isPresent()){
            chucVu = result.get();
        }else {
            throw new RuntimeException("khong tim thay id: " +id);
        }
        return chucVu;
    }

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.findAll();
    }
}
