package com.cbaservice.cba_backend.service.customer;

import com.cbaservice.cba_backend.helper.GlobalHttpResponse;
import com.cbaservice.cba_backend.payload.customer.CustomerInputDTO;
import com.cbaservice.cba_backend.payload.customer.CustomerOutputDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CustomerInterface {
    public GlobalHttpResponse<String> uploadImage(MultipartFile imageFile) throws IOException;
    public GlobalHttpResponse<byte[]> downloadImage(String imageName);
    public GlobalHttpResponse<List<CustomerOutputDTO>> findAll();
    public GlobalHttpResponse<CustomerOutputDTO> findById(Long id);
    public GlobalHttpResponse<CustomerOutputDTO> findByName(String name);
    public GlobalHttpResponse<CustomerOutputDTO> saveCustomer(CustomerInputDTO customer);
    public GlobalHttpResponse<CustomerOutputDTO> updateCustomer(Long id, CustomerInputDTO customer);
    public GlobalHttpResponse<CustomerOutputDTO> updateCustomerByName(String name, CustomerInputDTO customer);
    public GlobalHttpResponse<CustomerOutputDTO> deleteCustomer(Long id);


}
