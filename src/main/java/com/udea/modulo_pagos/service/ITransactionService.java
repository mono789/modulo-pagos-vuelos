package com.udea.modulo_pagos.service;

import com.udea.modulo_pagos.entities.Transaction;

public interface ITransactionService {

    void createTransaction(Transaction transaction);
    void updateTransactionStatus(Long id, String status);
}
