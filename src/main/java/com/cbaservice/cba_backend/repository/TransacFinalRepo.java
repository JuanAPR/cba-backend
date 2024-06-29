package com.cbaservice.cba_backend.repository;

import com.cbaservice.cba_backend.entity.transaction.TransactionFinal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacFinalRepo extends JpaRepository<TransactionFinal, Long> {
}
