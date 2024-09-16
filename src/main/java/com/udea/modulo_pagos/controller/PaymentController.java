package com.udea.modulo_pagos.controller;

import com.udea.modulo_pagos.entities.Payment;
import com.udea.modulo_pagos.graphql.InputPayment;
import com.udea.modulo_pagos.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @MutationMapping
    public Payment createPayment(@Argument InputPayment inputPayment) {

        Payment payment = new Payment();
        payment.setDate(inputPayment.getDate());
        payment.setTotal_paid(inputPayment.getTotal_paid());

        paymentService.createPayment(payment);

        return payment;
    }

    @QueryMapping(name= "findPaymentById")
    public Payment finById(@Argument (name = "paymentId") String id){

        Long paymentId = Long.parseLong(id);

        return paymentService.findbyId(paymentId);

    }
}
