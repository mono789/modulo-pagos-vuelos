package com.udea.modulo_pagos.controller;

import com.udea.modulo_pagos.entities.Booking;
import com.udea.modulo_pagos.entities.PaymentMethod;
import com.udea.modulo_pagos.entities.Transaction;
import com.udea.modulo_pagos.graphql.InputTransaction;
import com.udea.modulo_pagos.service.IBookingService;
import com.udea.modulo_pagos.service.IPaymentMethodService;
import com.udea.modulo_pagos.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @Autowired
    private IBookingService bookingService;

    @Autowired
    private IPaymentMethodService paymentMethodService;

    @SchemaMapping(typeName = "Transaction", field = "paymentMethod")
    public PaymentMethod getPaymentMethod(Transaction transaction) {
        return transaction.getPayment_method();
    }

    @SchemaMapping(typeName = "Transaction", field = "booking")
    public Booking getBooking(Transaction transaction) {
        return transaction.getBooking();
    }

    @MutationMapping
    public Transaction createTransaction(@Argument InputTransaction inputTransaction){
        return transactionService.createTransaction(inputTransaction);
    }

    @MutationMapping
    public Transaction updateTransactionStatus(@Argument Long transactionId, @Argument String newStatus) {
        return transactionService.updateTransactionStatus(transactionId, newStatus);
    }
}
