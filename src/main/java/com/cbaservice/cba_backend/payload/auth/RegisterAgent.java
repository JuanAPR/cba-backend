package com.cbaservice.cba_backend.payload.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterAgent {
    private String name;
    private String email;
    private String password;
}
