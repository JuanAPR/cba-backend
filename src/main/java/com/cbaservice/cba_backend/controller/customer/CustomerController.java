package com.cbaservice.cba_backend.controller.customer;

import com.cbaservice.cba_backend.payload.customer.CustomerOutputDTO;
import com.cbaservice.cba_backend.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @GetMapping("/all")
    public ResponseEntity<List<CustomerOutputDTO>> getAllCustomer(){
        var entity = service.findAll();
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
    @GetMapping("/{id}/detail")
    public ResponseEntity<CustomerOutputDTO> getCustomerById(@PathVariable("id") Long id){
        var entity = service.findById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @GetMapping("/{id}/delete")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id){
        try {
            service.deleteCustomer(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
