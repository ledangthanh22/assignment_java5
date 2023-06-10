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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "KhachHang")
public class KhachHang {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Name cannot be blank!")
    @Column(name = "Ma")
    private String code;

    @NotBlank(message = "Name cannot be blank!")
    @Column(name = "Ten")
    private String name;

    @Column(name = "NgaySinh")
    private Date birthday;

    @NotBlank(message = "Address cannot be blank!")
    @Column(name = "DiaChi")
    private String address;

    @NotBlank(message = "Number phone cannot be blank!")
    @Column(name = "Sdt")
    private String numberPhone;

    @NotBlank(message = "City cannot be blank!")
    @Column(name = "ThanhPho")
    private String city;

    @NotBlank(message = "Nation cannot be blank!")
    @Column(name = "QuocGia")
    private String nation;

}
