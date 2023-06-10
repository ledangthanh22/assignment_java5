package com.poly.assignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "CuaHang")
public class CuaHang {

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

    @NotBlank(message = "Address cannot be blank!")
    @Column(name = "DiaChi")
    private String address;

    @NotBlank(message = "City cannot be blank!")
    @Column(name = "ThanhPho")
    private String city;

    @NotBlank(message = "Nation cannot be blank!")
    @Column(name = "QuocGia")
    private String nation;
}
