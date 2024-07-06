package com.cbaservice.cba_backend.payload.category;

import com.cbaservice.cba_backend.entity.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryInputDTO {
    private String name;

    public Category dtoToEntity(){
        Category category = new Category();
        category.setName(name);
        return category;
    }
}
