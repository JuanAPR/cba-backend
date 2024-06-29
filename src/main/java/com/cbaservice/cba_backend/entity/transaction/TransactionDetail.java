package com.cbaservice.cba_backend.entity.transaction;

import com.cbaservice.cba_backend.entity.customer.Customer;
import com.cbaservice.cba_backend.entity.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction_detail", catalog = "cba")
public class TransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "transaction_code", nullable = false)
    private Integer transactionCode;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Customer customer;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private Product product;
    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity;
    @Column(name = "subtotal", nullable = false)
    private Integer subtotal;
    @Column(name = "tanggal_sewa")
    private LocalDate tanggalSewa;
    @Column(name = "akhir_sewa")
    private LocalDate akhirSewa;
    @Column(name = "tanggal_kirim")
    private LocalDate tanggalKirim;
    @Column(name = "tanggal_terima")
    private LocalDate tanggalTerima;
    @Column(name = "tanggal_buat", nullable = false)
    private LocalDate createdAt;
    @OneToMany(mappedBy = "transactionDetail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<TransactionFinal> finalList;
}
