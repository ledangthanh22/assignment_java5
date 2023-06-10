package com.poly.assignment.service.impl;

import com.poly.assignment.entity.CuaHang;
import com.poly.assignment.repository.CuaHangRepsitory;
import com.poly.assignment.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {

    @Autowired
    private CuaHangRepsitory cuaHangRepsitory;

    @Override
    public Page<CuaHang> findPaginated(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return cuaHangRepsitory.findAll(pageable);
    }

    @Override
    public void save(CuaHang ch) {
       cuaHangRepsitory.save(ch);
    }

    @Override
    public void delete(UUID id) {
         cuaHangRepsitory.deleteById(id);
    }

    @Override
    public CuaHang getOne(UUID id) {
        Optional<CuaHang> result = cuaHangRepsitory.findById(id);
        CuaHang cuaHang = null;
        if (result.isPresent()){
            cuaHang = result.get();
        }else {
            throw new RuntimeException("Khong tim thay id: "+id);
        }
        return cuaHang;
    }

    @Override
    public List<CuaHang> getAll() {
        return cuaHangRepsitory.findAll();
    }
}
