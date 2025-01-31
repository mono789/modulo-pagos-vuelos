package com.udea.modulo_pagos.service;

import com.udea.modulo_pagos.entities.PaymentMethod;

import java.util.List;

public interface IPaymentMethodService {

    List<PaymentMethod> allPaymentMethods();

    boolean checkCard(String cardNumber, String ccv, String cardType, String expiryDate);
}
