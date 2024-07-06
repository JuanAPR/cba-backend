package com.cbaservice.cba_backend.controller.product;

import com.cbaservice.cba_backend.payload.product.ProductInputDTO;
import com.cbaservice.cba_backend.payload.product.ProductOutputDTO;
import com.cbaservice.cba_backend.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/")
    public ResponseEntity<List<ProductOutputDTO>> getAllProduct(){
        var entity = service.findAll();
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @GetMapping("/{id}/detail")
    public ResponseEntity<ProductOutputDTO> getProductById(@PathVariable("id")Long id){
        var entity = service.findById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ProductOutputDTO> addProduct(@RequestBody ProductInputDTO productInputDTO){
        var entity = service.saveProduct(productInputDTO);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/detail")
    public ResponseEntity<ProductOutputDTO> updateProduct(@PathVariable("id") Long id,@RequestBody ProductInputDTO inputDTO){
        var entity = service.updateProduct(id, inputDTO);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
        service.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
