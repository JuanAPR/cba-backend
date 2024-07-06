package com.cbaservice.cba_backend.service.transaction;

import com.cbaservice.cba_backend.payload.transaction.TransactionFinalInputDTO;
import com.cbaservice.cba_backend.payload.transaction.TransactionFinalOutputDTO;

import java.util.List;

public interface TransactionFinalInterface {
    public List<TransactionFinalOutputDTO> findAll();
    public TransactionFinalOutputDTO findById(Long id);
    public TransactionFinalOutputDTO findByName(String name);
    public TransactionFinalOutputDTO saveTransactionFinal(TransactionFinalInputDTO finalInput);
    public TransactionFinalOutputDTO updateTransactionFinal(Long id, TransactionFinalInputDTO finalInput);
    public TransactionFinalOutputDTO updateTransactionFinalByName(String name, TransactionFinalInputDTO finalInput);
    public void deleteTransactionFinal(Long id);
}
