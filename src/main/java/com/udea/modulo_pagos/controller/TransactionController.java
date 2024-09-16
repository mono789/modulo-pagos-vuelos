package com.udea.modulo_pagos.controller;

import com.udea.modulo_pagos.entities.Transaction;
import com.udea.modulo_pagos.graphql.InputTransaction;
import com.udea.modulo_pagos.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @MutationMapping
    public Transaction createTransaction(@Argument InputTransaction inputTransaction){

        Transaction transaction = new Transaction();
        transaction.setStatus(inputTransaction.getStatus());
        transaction.setDate(inputTransaction.getDate());
        transaction.setAdditional_charge(inputTransaction.getAdditional_charge());
        transaction.setTotal_price(inputTransaction.getTotal_price());

        transactionService.createTransaction(transaction);

        return transaction;
    }

    @MutationMapping
    public String updateTransactionStatus(@Argument Long transactionId, @Argument String newStatus) {
        try {
            transactionService.updateTransactionStatus(transactionId, newStatus);
            return "Transaction status updated successfully";
        } catch (Exception e) {
            return "Error updating transaction status: " + e.getMessage();
        }
    }
}
