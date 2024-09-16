package com.udea.modulo_pagos.service.implementation;

import com.udea.modulo_pagos.entities.Transaction;
import com.udea.modulo_pagos.repositories.ITransactionRepository;
import com.udea.modulo_pagos.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private ITransactionRepository transactionRepository;

    public void createTransaction(Transaction transaction){
        transactionRepository.save(transaction);

    }

    public void updateTransactionStatus(Long id, String status){
        var transaction= new Transaction ();
        transaction= transactionRepository.findById(id).orElseThrow();
        transaction.setStatus(status);
        transactionRepository.save(transaction);

    }


}
