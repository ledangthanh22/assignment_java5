package com.poly.assignment.service.impl;

import com.poly.assignment.entity.ThuongHieu;
import com.poly.assignment.repository.ThuongHieuReository;
import com.poly.assignment.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {

    @Autowired
    private ThuongHieuReository thuongHieuReository;

    @Override
    public List<ThuongHieu> getAll() {
        return thuongHieuReository.findAll();
    }

    @Override
    public Page<ThuongHieu> findPaginated(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return thuongHieuReository.findAll(pageable);
    }

    @Override
    public void save(ThuongHieu th) {
        thuongHieuReository.save(th);
    }

    @Override
    public void delete(UUID id) {
        thuongHieuReository.deleteById(id);
    }

    @Override
    public ThuongHieu getOne(UUID id) {
        Optional<ThuongHieu> result = thuongHieuReository.findById(id);
        ThuongHieu thuongHieu = null;
        if (result.isPresent()) {
            thuongHieu = result.get();
        } else {
            throw new RuntimeException("Khong tim thay id: " + id);
        }
        return thuongHieu;
    }
}
