package com.cbaservice.cba_backend.service.customer;

import com.cbaservice.cba_backend.payload.customer.CustomerInputDTO;
import com.cbaservice.cba_backend.payload.customer.CustomerOutputDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CustomerInterface {
    public String uploadImage(MultipartFile imageFile) throws IOException;
    public byte[] downloadImage(String imageName);
    public List<CustomerOutputDTO> findAll();
    public CustomerOutputDTO findById(Long id);
    public CustomerOutputDTO findByName(String name);
    public CustomerOutputDTO saveCustomer(CustomerInputDTO customer);
    public CustomerOutputDTO updateCustomer(Long id, CustomerInputDTO customer);
    public CustomerOutputDTO updateCustomerByName(String name, CustomerInputDTO customer);
    public void deleteCustomer(Long id);


}
