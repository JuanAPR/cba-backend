package com.cbaservice.cba_backend.payload.customer;

import com.cbaservice.cba_backend.entity.auth.Agent;
import com.cbaservice.cba_backend.entity.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInputDTO {
    private String name;
    private String email;
    private int phone;
    private String address;
    private String city;
    private String ktp;
    private String tempatLahir;
    private LocalDate tanggalLahir;
    private Integer age;
    private String passportID;
    private String nationality;
    private int agentId;

    public Customer dtoToEntity(){
        Customer customer = new Customer();
        Agent agent = new Agent();
        agent.setId(agentId);

        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setCity(city);
        customer.setKtp(ktp);
        customer.setTempatLahir(tempatLahir);
        customer.setTanggalLahir(tanggalLahir);
        customer.setAge(age);
        customer.setPassportId(passportID);
        customer.setNationality(nationality);
        return customer;
    }
}
