package com.udea.modulo_pagos.service.implementation;

import com.udea.modulo_pagos.entities.Payment;
import com.udea.modulo_pagos.repositories.IPaymentRepository;
import com.udea.modulo_pagos.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    private IPaymentRepository paymentRepository;

    @Override
    public void createPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public Payment findbyId(Long id) {
        return paymentRepository.findById(id).orElseThrow();
    }
}
