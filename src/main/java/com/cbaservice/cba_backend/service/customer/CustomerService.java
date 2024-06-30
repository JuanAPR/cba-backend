package com.cbaservice.cba_backend.service.customer;

import com.cbaservice.cba_backend.entity.auth.Agent;
import com.cbaservice.cba_backend.entity.customer.Customer;
import com.cbaservice.cba_backend.helper.GlobalHttpResponse;
import com.cbaservice.cba_backend.payload.customer.CustomerInputDTO;
import com.cbaservice.cba_backend.payload.customer.CustomerOutputDTO;
import com.cbaservice.cba_backend.repository.AgentRepo;
import com.cbaservice.cba_backend.repository.CustomerRepo;
import com.cbaservice.cba_backend.util.ImageUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerInterface{
    private final CustomerRepo customerRepo;
    private final AgentRepo agentRepo;

    @Override
    public String uploadImage(MultipartFile imageFile) throws IOException {
        var imageToSave = Customer.builder()
                .name(imageFile.getOriginalFilename())
                .imageData(ImageUtil.compressImage(imageFile.getBytes()))
                .build();
        customerRepo.save(imageToSave);
        return "File uploaded: "+ imageFile.getOriginalFilename();
    }

    @Override
    public byte[] downloadImage(String imageName) {
        Optional<Customer> dbImage = customerRepo.findByName(imageName);
        return dbImage.map(image ->{
            try {
                return ImageUtil.decompressImage(image.getImageData());
            } catch (DataFormatException|IOException exception){
                throw new ContextedRuntimeException("Error downloading an image", exception)
                        .addContextValue("Image ID", image.getId())
                        .addContextValue("Image name", imageName);
            }
        }).orElse(null);
    }

    @Override
    public List<CustomerOutputDTO> findAll() {
        List<Customer> customers = customerRepo.findAll();
        List<CustomerOutputDTO> output = new ArrayList<>();
        for(Customer data : customers){
            output.add(data.entityToDTO());
        }
        return output;
    }

    @Override
    public CustomerOutputDTO findById(Long id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if(customer.isEmpty()) {
            throw new RuntimeException("Data not found");
        } else {
            return customer.get().entityToDTO();
        }
    }

    @Override
    public CustomerOutputDTO findByName(String name) {
        Optional<Customer> customer = customerRepo.findByName(name);
        if(customer.isEmpty()){
            throw new RuntimeException("Data not found");
        } else {
            return customer.get().entityToDTO();
        }
    }
    @Transactional
    @Override
    public CustomerOutputDTO saveCustomer(CustomerInputDTO customer) {
        try{
            Customer custom = customer.dtoToEntity();
            Agent agent = agentRepo.findById(customer.getAgentId()).orElse(null);
            if(agent == null){
                throw new NullPointerException();
            } else {
                custom.setAgent(agent);
                Customer entity = customerRepo.save(custom);
                return entity.entityToDTO();
            }
        } catch (NullPointerException e) {
            throw new RuntimeException("Data not found");
        }
    }
    @Transactional
    @Override
    public CustomerOutputDTO updateCustomer(Long id, CustomerInputDTO customer) {
        Optional<Customer> custom = customerRepo.findById(id);
        if(custom.isEmpty()){
            throw new RuntimeException("Product not found");
        }
        Agent agent = agentRepo.findById(customer.getAgentId()).orElse(null);
        if(agent == null){
            throw new RuntimeException("Agent not found");
        }
        Customer entity = custom.get();
        entity.setName(customer.getName());
        entity.setEmail(customer.getEmail());
        entity.setPhone(customer.getPhone());
        entity.setAddress(customer.getAddress());
        entity.setKtp(customer.getKtp());
        entity.setCity(customer.getCity());
        entity.setTempatLahir(customer.getTempatLahir());
        entity.setTanggalLahir(customer.getTanggalLahir());
        entity.setAge(customer.getAge());
        entity.setPassportId(customer.getPassportID());
        entity.setNationality(customer.getNationality());
        entity.setUpdateAt(LocalDate.now());
        Customer customEntity = customerRepo.save(entity);
        return customEntity.entityToDTO();
    }
    @Transactional
    @Override
    public CustomerOutputDTO updateCustomerByName(String name, CustomerInputDTO customer) {
        Optional<Customer> custom = customerRepo.findByName(name);
        if(custom.isEmpty()){
            throw new RuntimeException("Product not found");
        }
        Agent agent = agentRepo.findById(customer.getAgentId()).orElse(null);
        if(agent == null){
            throw new RuntimeException("Agent not found");
        }
        Customer entity = custom.get();
        entity.setName(customer.getName());
        entity.setEmail(customer.getEmail());
        entity.setPhone(customer.getPhone());
        entity.setAddress(customer.getAddress());
        entity.setKtp(customer.getKtp());
        entity.setCity(customer.getCity());
        entity.setTempatLahir(customer.getTempatLahir());
        entity.setTanggalLahir(customer.getTanggalLahir());
        entity.setAge(customer.getAge());
        entity.setPassportId(customer.getPassportID());
        entity.setNationality(customer.getNationality());
        entity.setUpdateAt(LocalDate.now());
        Customer customEntity = customerRepo.save(entity);
        return customEntity.entityToDTO();
    }
    @Transactional
    @Override
    public void deleteCustomer (Long id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if(customer.isEmpty()){
            throw new RuntimeException("DCustomer Not Found");
        }
        customerRepo.deleteById(id);
    }
}
