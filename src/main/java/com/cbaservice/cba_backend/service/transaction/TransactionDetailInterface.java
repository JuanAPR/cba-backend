package com.cbaservice.cba_backend.service.transaction;

import com.cbaservice.cba_backend.payload.transaction.TransactionDetailInputDTO;
import com.cbaservice.cba_backend.payload.transaction.TransactionDetailOutputDTO;

import java.util.List;

public interface TransactionDetailInterface {
    public List<TransactionDetailOutputDTO> findAll();
    public TransactionDetailOutputDTO findById(Long id);
    public TransactionDetailOutputDTO findByName(String name);
    public TransactionDetailOutputDTO saveTransactionDetail(TransactionDetailInputDTO detailInput);
    public TransactionDetailOutputDTO updateTransactionDetail(Long id, TransactionDetailInputDTO detailInput);
    public TransactionDetailOutputDTO updateTransactionDetailByName(String name, TransactionDetailInputDTO detailInput);
    public void deleteTransactionDetail(Long id);
}
