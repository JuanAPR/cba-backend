package com.cbaservice.cba_backend.repository;

import com.cbaservice.cba_backend.entity.auth.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgentRepo extends JpaRepository<Agent, Integer> {
    Optional<Agent> findByEmail(String email);
}
