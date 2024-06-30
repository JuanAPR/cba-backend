package com.cbaservice.cba_backend.entity.product;

import com.cbaservice.cba_backend.entity.category.Category;
import com.cbaservice.cba_backend.entity.transaction.TransactionDetail;
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
@Table(name = "table", catalog = "cba")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Category category;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "image")
    private String image;
    @Column(name = "tanggal_buat")
    private LocalDate createdAt;
    @Column(name = "tanggal_update")
    private LocalDate updatedAt;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<TransactionDetail> transactionDetails;
}
