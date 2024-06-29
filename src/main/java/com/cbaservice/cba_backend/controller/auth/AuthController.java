package com.cbaservice.cba_backend.controller.auth;

import com.cbaservice.cba_backend.payload.auth.AuthRequest;
import com.cbaservice.cba_backend.payload.auth.AuthResponse;
import com.cbaservice.cba_backend.payload.auth.RegisterAgent;
import com.cbaservice.cba_backend.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;

    @PostMapping("/agent/register")
    public ResponseEntity<AuthResponse> registerUser(@RequestBody RegisterAgent register){
        return ResponseEntity.ok(service.registerUser(register));
    }

    @PostMapping("/agent/login")
    public ResponseEntity<AuthResponse> login (@RequestBody AuthRequest request){
        return ResponseEntity.ok(service.login(request));
    }
}
