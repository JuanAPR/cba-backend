package com.cbaservice.cba_backend.payload.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryOutputDTO {
    private Long id;
    private String name;
    private LocalDate tanggalBuat;
    private LocalDate tanggalUpdate;
}
