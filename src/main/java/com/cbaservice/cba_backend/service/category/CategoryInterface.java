package com.cbaservice.cba_backend.service.category;

import com.cbaservice.cba_backend.payload.category.CategoryInputDTO;
import com.cbaservice.cba_backend.payload.category.CategoryOutputDTO;

import java.util.List;

public interface CategoryInterface {
    public List<CategoryOutputDTO> findAll();
    public CategoryOutputDTO findById(Long id);
    public CategoryOutputDTO findByName(String name);
    public CategoryOutputDTO saveCategory(CategoryInputDTO categoryInputDTO);
    public CategoryOutputDTO updateCategory(Long id, CategoryInputDTO categoryInputDTO);
    public CategoryOutputDTO updateCategoryByName(String name, CategoryInputDTO categoryInputDTO);
    public void deleteCategory(Long id);
}
