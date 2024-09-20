package com.udea.modulo_pagos.service.implementation;

import com.udea.modulo_pagos.entities.Booking;
import com.udea.modulo_pagos.entities.GatewayPayment;
import com.udea.modulo_pagos.entities.Payment;
import com.udea.modulo_pagos.entities.Transaction;
import com.udea.modulo_pagos.graphql.InputPayment;
import com.udea.modulo_pagos.repositories.IPaymentRepository;
import com.udea.modulo_pagos.repositories.ITransactionRepository;
import com.udea.modulo_pagos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
public class PaymentServiceImpl implements IPaymentService {
    private static final String[] STATUSES = {"PENDING", "SUCCESS", "FAILED", "CANCELLED"};

    @Autowired
    private IPaymentRepository paymentRepository;
    private ITransactionRepository transactionRepository;

    @Autowired
    private ITransactionService transactionService;

    @Autowired
    private IGatewayPaymentService gatewayPaymentService;

    @Autowired
    private IBookingService bookingService;

    @Override
    public Payment createPayment(InputPayment inputPayment) {
        GatewayPayment gatewayPayment = gatewayPaymentService.findGatewayPaymentById(inputPayment.getGateway_payment_id());
        Transaction transaction = transactionService.findTransactionById(inputPayment.getTransaction_id());
        if (transaction.getStatus().equals("SUCCESS")){
            throw new IllegalStateException("No se puede realizar el pago nuevamente, el estado de la transacción es SUCCESS.");
        }
        Payment payment = new Payment();
        payment.setTransaction(transaction);
        payment.setGatewayPayment(gatewayPayment);
        payment.setDate(LocalDate.now());
        payment.setTotal_paid(transaction.getTotal_price()+transaction.getAdditional_charge());
        payment.setDate(LocalDate.now());

        Random random = new Random();
        int index = random.nextInt(STATUSES.length); // Elige un índice aleatorio
        payment.setPaymentStatus(STATUSES[index]);

        transactionService.updateTransactionStatus(inputPayment.getTransaction_id(), STATUSES[index]);
        bookingService.updateBookingStatus(transaction.getBooking().getId(), STATUSES[index]+"_PAYMENT");

        paymentRepository.save(payment);

        return payment;
    }

    @Override
    public Payment findPaymentById(Long payment_id) {
        return paymentRepository.findById(payment_id).orElseThrow();
    }
}
