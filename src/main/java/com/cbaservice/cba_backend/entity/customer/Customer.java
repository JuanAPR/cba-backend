package com.cbaservice.cba_backend.entity.customer;

import com.cbaservice.cba_backend.entity.auth.Agent;
import com.cbaservice.cba_backend.entity.transaction.TransactionDetail;
import com.cbaservice.cba_backend.payload.customer.CustomerOutputDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;


import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer", catalog = "cba")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "agent_id", referencedColumnName = "id",nullable = false)
    @JsonBackReference
    private Agent agent;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone", nullable = false)
    private Integer phone;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "ktp", nullable = false)
    private String ktp;
    @Column(name = "tempat_lahir", nullable = false)
    private String tempatLahir;
    @Column(name = "tanggal_lahir", nullable = false)
    private LocalDate tanggalLahir;
    @Column(name = "age")
    private Integer age;
    @Column(name = "passport_id")
    private String passportId;
    @Column(name = "nationality")
    private String nationality;
    @Lob
    @Column(name = "image_data")
    @JdbcTypeCode(Types.LONGVARBINARY)
    private byte[] imageData;
    @Column(name = "tanggal_buat")
    private LocalDate createdAt;
    @Column(name = "tanggal_update")
    private LocalDate updateAt;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<TransactionDetail> transactionDetails;

    public CustomerOutputDTO entityToDTO(){
        CustomerOutputDTO customerOutputDTO = new CustomerOutputDTO();
        List<TransactionDetail> model = new ArrayList<>();

        customerOutputDTO.setId(id);
        customerOutputDTO.setName(name);
        customerOutputDTO.setPhone(phone);
        customerOutputDTO.setAddress(address);
        customerOutputDTO.setCity(city);
        customerOutputDTO.setEmail(email);
        customerOutputDTO.setKtp(ktp);
        customerOutputDTO.setTempatLahir(tempatLahir);
        customerOutputDTO.setTanggalLahir(tanggalLahir);
        customerOutputDTO.setAge(age);
        customerOutputDTO.setPassportID(passportId);
        customerOutputDTO.setNationality(nationality);
        customerOutputDTO.setCreatedAt(LocalDate.now());
        customerOutputDTO.setUpdatedAt(null);
        return customerOutputDTO;
    }
}
