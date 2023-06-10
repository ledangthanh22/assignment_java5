package com.poly.assignment.repository;

import com.poly.assignment.entity.SanPhamCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SanPhamCTRepository extends JpaRepository<SanPhamCT, UUID> {
}
