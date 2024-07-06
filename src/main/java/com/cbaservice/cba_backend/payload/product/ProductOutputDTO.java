package com.cbaservice.cba_backend.payload.product;

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
public class ProductOutputDTO {
    private Long id;
    private String categoryName;
    private Long categoryId;
    private String name;
    private String image;
    private BigDecimal price;
    private LocalDate tanggalBuat;
    private LocalDate tanggalUpdate;
}
