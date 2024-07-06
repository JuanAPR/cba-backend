package com.cbaservice.cba_backend.service.product;

import com.cbaservice.cba_backend.entity.category.Category;
import com.cbaservice.cba_backend.entity.product.Product;
import com.cbaservice.cba_backend.payload.product.ProductInputDTO;
import com.cbaservice.cba_backend.payload.product.ProductOutputDTO;
import com.cbaservice.cba_backend.repository.CategoryRepo;
import com.cbaservice.cba_backend.repository.ProductRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductInterface{
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    @Override
    public List<ProductOutputDTO> findAll() {
        List<Product> products = productRepo.findAll();
        List<ProductOutputDTO> outputs = new ArrayList<>();
        for(Product data : products){
            outputs.add(data.entityToDto());
        }
        return outputs;
    }

    @Override
    public ProductOutputDTO findById(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if(product.isEmpty()){
            throw new RuntimeException("Data not found");
        } else {
            return product.get().entityToDto();
        }
    }

    @Override
    public ProductOutputDTO findByName(String name) {
        return null;
    }

    @Override
    public ProductOutputDTO saveProduct(ProductInputDTO productInput) {
        try{
            Product product = productInput.dtoToEntity();
            Category category = categoryRepo.findById(productInput.getCategoryId()).orElse(null);
            if(category == null){
                throw new NullPointerException();
            } else {
                product.setCategory(category);
                Product entity = productRepo.save(product);
                return entity.entityToDto();
            }
        } catch (NullPointerException e){
            throw new RuntimeException("Data not found");
        }
    }

    @Transactional
    @Override
    public ProductOutputDTO updateProduct(Long id, ProductInputDTO productInput) {
        Optional<Product> product = productRepo.findById(id);
        if(product.isEmpty()){
            throw new RuntimeException("Data not found");
        }
        Category category = categoryRepo.findById(productInput.getCategoryId()).orElse(null);
        if(category == null){
            throw new RuntimeException("Category not found");
        }
        Product entity = product.get();
        entity.setName(productInput.getName());
        entity.setImage(productInput.getImage());
        entity.setPrice(productInput.getPrice());
        entity.setUpdatedAt(LocalDate.now());
        entity.setCategory(category);
        Product result = productRepo.save(entity);
        return result.entityToDto();
        //TODO update exception, added rollback
    }

    @Override
    public ProductOutputDTO updateProductByName(String name, ProductInputDTO productInputDTO) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if(product.isEmpty()){
            throw new NullPointerException();
        } else {
            productRepo.deleteById(id);
        }
    }
}
