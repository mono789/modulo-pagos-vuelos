package com.udea.modulo_pagos.service.implementation;

import com.udea.modulo_pagos.entities.PaymentMethod;
import com.udea.modulo_pagos.repositories.IPaymentMethodRepository;
import com.udea.modulo_pagos.service.IPaymentMethodService;
import com.udea.modulo_pagos.utils.CreditCardValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodServiceImpl implements IPaymentMethodService {

    @Autowired
    private IPaymentMethodRepository paymentMethodRepository;

    public List<PaymentMethod> allPaymentMethods() {
        Iterable<PaymentMethod> iterable = paymentMethodRepository.findAll();
        List<PaymentMethod> paymentMethods = new ArrayList<>();

        // Iterar sobre el iterable y agregar los elementos a la lista
        for (PaymentMethod paymentMethod : iterable) {
            paymentMethods.add(paymentMethod);
        }

        return paymentMethods;
    }

    public boolean checkCard(String cardNumber, String ccv, String cardType, String expiryDate){

        return CreditCardValidator.isValidCard(cardNumber) && CreditCardValidator.isValidCCV(ccv, cardType) && CreditCardValidator.isValidExpiryDate(expiryDate);

    }
}
