package com.cbaservice.cba_backend.entity.transaction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction_final", catalog = "cba")
public class TransactionFinal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_detail_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private TransactionDetail transactionDetail;
    @Column(name = "total_pay", nullable = false)
    private BigDecimal totalPay;
    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;
    @Column(name = "tanggal_transaksi", nullable = false)
    private LocalDate transcDate;
}
