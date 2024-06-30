package com.cbaservice.cba_backend.payload.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOutputDTO {
    private Long id;
    private String name;
    private String email;
    private int phone;
    private String address;
    private String city;
    private String ktp;
    private String tempatLahir;
    private LocalDate tanggalLahir;
    private Integer age;
    private String passportID;
    private String nationality;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
