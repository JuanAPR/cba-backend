package com.cbaservice.cba_backend.payload.product;

import com.cbaservice.cba_backend.entity.category.Category;
import com.cbaservice.cba_backend.entity.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductInputDTO {
    private String name;
    private BigDecimal price;
    private String image;
    private Long categoryId;

    public Product dtoToEntity(){
        Product product = new Product();
        Category category = new Category();
        category.setId(categoryId);

        product.setName(name);
        product.setPrice(price);
        product.setImage(image);

        return product;
    }
}
