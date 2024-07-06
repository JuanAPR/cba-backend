package com.cbaservice.cba_backend.entity.category;

import com.cbaservice.cba_backend.entity.product.Product;
import com.cbaservice.cba_backend.payload.category.CategoryOutputDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category_product", catalog = "cba")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "tanggal_buat")
    private LocalDate createdAt;
    @Column(name ="tanggal_update")
    private LocalDate updatedAt;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Product> products;

    public CategoryOutputDTO entityToDto(){
        CategoryOutputDTO category = new CategoryOutputDTO();

        category.setId(id);
        category.setName(name);
        category.setTanggalBuat(LocalDate.now());
        category.setTanggalUpdate(null);
        return category;
    }
}
