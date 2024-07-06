package com.cbaservice.cba_backend.controller.category;

import com.cbaservice.cba_backend.payload.category.CategoryInputDTO;
import com.cbaservice.cba_backend.payload.category.CategoryOutputDTO;
import com.cbaservice.cba_backend.service.category.CategoryService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping("/")
    public ResponseEntity<List<CategoryOutputDTO>> getAllCategory(){
        var entity = service.findAll();
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @GetMapping("/{id]/detail")
    public ResponseEntity<CategoryOutputDTO> getCategoryById(@PathVariable("id") Long id){
        var entity = service.findById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @GetMapping("/{name}/detail")
    public ResponseEntity<CategoryOutputDTO> getCategoryByName(@PathVariable("name") String name){
        var entity = service.findByName(name);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CategoryOutputDTO> addCategory(@RequestBody CategoryInputDTO category){
        var entity = service.saveCategory(category);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryOutputDTO> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryInputDTO categoryInputDTO){
        var entity = service.updateCategory(id, categoryInputDTO);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        service.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
