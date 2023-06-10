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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "NhanVien")
public class NhanVien {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Code cannot be blank!")
    @Column(name = "Ma")
    private String code;

    @NotBlank(message = "Name cannot be blank!")
    @Column(name = "Ten")
    private String name;

    @Column(name = "GioiTinh")
    private Boolean gender;

    @Column(name = "NgaySinh")
    private Date birthday;

    @NotBlank(message = "Address cannot be blank!")
    @Column(name = "DiaChi")
    private String address;

    @NotBlank(message = "Email cannot be blank!")
    @Column(name = "Email")
    private String email;

    @NotBlank(message = "Number phone cannot be blank!")
    @Column(name = "Sdt")
    private String numberPhone;

    @Column(name = "TrangThai")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCH",referencedColumnName = "Id")
    private CuaHang cuaHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCV",referencedColumnName = "Id")
    private ChucVu chucVu;
}
