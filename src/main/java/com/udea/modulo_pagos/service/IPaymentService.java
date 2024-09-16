package com.udea.modulo_pagos.service;

import com.udea.modulo_pagos.entities.Payment;

public interface IPaymentService {

    void createPayment (Payment payment);

    Payment findbyId(Long id);
}
