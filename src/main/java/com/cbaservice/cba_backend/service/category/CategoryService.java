package com.cbaservice.cba_backend.service.category;

import com.cbaservice.cba_backend.entity.category.Category;
import com.cbaservice.cba_backend.payload.category.CategoryInputDTO;
import com.cbaservice.cba_backend.payload.category.CategoryOutputDTO;
import com.cbaservice.cba_backend.repository.CategoryRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryInterface{
    private final CategoryRepo categoryRepo;

    @Override
    public List<CategoryOutputDTO> findAll() {
        List<Category> category = categoryRepo.findAll();
        List<CategoryOutputDTO> output = new ArrayList<>();
        for(Category data : category){
            output.add(data.entityToDto());
        }
        return output;
    }

    @Override
    public CategoryOutputDTO findById(Long id) {
        Optional<Category> category = categoryRepo.findById(id);
        if(category.isEmpty()){
            throw new RuntimeException("Data not found");
        } else {
            return category.get().entityToDto();
        }
    }

    @Override
    public CategoryOutputDTO findByName(String name) {
        Optional<Category> category = categoryRepo.findByName(name);
        if(category.isEmpty()){
            throw new RuntimeException("Data not found");
        } else {
            return category.get().entityToDto();
        }
    }

    @Transactional
    @Override
    public CategoryOutputDTO saveCategory(CategoryInputDTO categoryInputDTO) {
        try{
            Category category = categoryInputDTO.dtoToEntity();
            categoryRepo.save(category);
            return category.entityToDto();
        } catch (NullPointerException e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new RuntimeException("Data not found");
        }
    }

    @Override
    public CategoryOutputDTO updateCategory(Long id, CategoryInputDTO categoryInputDTO) {
        Optional<Category> entity = categoryRepo.findById(id);
        if(entity.isEmpty()){
            throw new RuntimeException("Data not found");
        } else {
            Category category = entity.get();
            category.setName(category.getName());
            category.setUpdatedAt(LocalDate.now());
            categoryRepo.save(category);
            return category.entityToDto();
        }
    }

    @Override
    public CategoryOutputDTO updateCategoryByName(String name, CategoryInputDTO categoryInputDTO) {
        Optional<Category> entity = categoryRepo.findByName(name);
        if(entity.isEmpty()){
            throw new RuntimeException("Data not found");
        } else {
            Category category = entity.get();
            category.setName(categoryInputDTO.getName());
            category.setUpdatedAt(LocalDate.now());
            categoryRepo.save(category);
            return category.entityToDto();
        }
    }

    @Override
    public void deleteCategory(Long id) {
        Optional<Category> entity = categoryRepo.findById(id);
        if(entity.isEmpty()){
            throw new RuntimeException("Data not found");
        } else {
            categoryRepo.deleteById(id);
        }
    }
}
