package com.cbaservice.cba_backend.service.product;

import com.cbaservice.cba_backend.payload.product.ProductInputDTO;
import com.cbaservice.cba_backend.payload.product.ProductOutputDTO;

import java.util.List;

public interface ProductInterface {
    public List<ProductOutputDTO> findAll();
    public ProductOutputDTO findById(Long id);
    public ProductOutputDTO findByName(String name);
    public ProductOutputDTO saveProduct(ProductInputDTO productInput);
    public ProductOutputDTO updateProduct(Long id, ProductInputDTO productInput);
    public ProductOutputDTO updateProductByName(String name, ProductInputDTO productInputDTO);
    public void deleteProduct(Long id);
}
