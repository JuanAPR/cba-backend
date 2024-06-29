package com.cbaservice.cba_backend.service.auth;

import com.cbaservice.cba_backend.entity.auth.Agent;
import com.cbaservice.cba_backend.helper.GlobalHttpResponse;
import com.cbaservice.cba_backend.helper.Role;
import com.cbaservice.cba_backend.payload.auth.AuthRequest;
import com.cbaservice.cba_backend.payload.auth.AuthResponse;
import com.cbaservice.cba_backend.payload.auth.RegisterAgent;
import com.cbaservice.cba_backend.repository.AgentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AgentRepo agentRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse registerUser (RegisterAgent register){
        var user = Agent.builder()
                .name(register.getName())
                .email(register.getEmail())
                .password(passwordEncoder.encode(register.getPassword()))
                .role(Role.USER)
                .build();
        agentRepo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken).build();
    }

    public AuthResponse registerAdmin (RegisterAgent register){
        var user = Agent.builder()
                .name(register.getName())
                .email(register.getEmail())
                .password(passwordEncoder.encode(register.getPassword()))
                .role(Role.ADMIN)
                .build();
        agentRepo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken).build();
    }
    public AuthResponse login(AuthRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = agentRepo.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken).build();
    }
    public Agent getAgentFromToken (String token) {
        String email = jwtService.extractEmail(token);
        return agentRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("Agent not found"));
    }
}
