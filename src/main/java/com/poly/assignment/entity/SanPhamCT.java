package com.poly.assignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "SanPhamCT")
public class SanPhamCT {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSP",referencedColumnName = "Id")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMS",referencedColumnName = "Id")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdLSP",referencedColumnName = "Id")
    private LoaiSanPham loaiSanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdTH",referencedColumnName = "Id")
    private ThuongHieu thuongHieu;

    @NotNull(message = "Price cannot be blank!")
    @Column(name = "Gia")
    private Double price;

    @NotNull(message = "Warranty year cannot be blank!")
    @Column(name = "namBH")
    private Integer warrantyYear;

    @NotNull(message = "Quantity year cannot be blank!")
    @Column(name = "SoLuongTon")
    private Integer quantity;

    @NotBlank(message = "Describe year cannot be blank!")
    @Column(name = "MoTa")
    private String describe;

}
