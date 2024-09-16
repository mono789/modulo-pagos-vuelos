package com.udea.modulo_pagos.service.implementation;

import com.udea.modulo_pagos.entities.GatewayPayment;
import com.udea.modulo_pagos.entities.PaymentMethod;
import com.udea.modulo_pagos.repositories.IGatewayPaymentRepository;
import com.udea.modulo_pagos.repositories.IPaymentMethodRepository;
import com.udea.modulo_pagos.service.IGatewayPaymentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GatewayPaymentServiceImpl implements IGatewayPaymentService {

    @Autowired
    private IGatewayPaymentRepository gatewayPaymentRepository;

    public List<GatewayPayment> allPaymentMethods() {
        Iterable<GatewayPayment> iterable = gatewayPaymentRepository.findAll();
        List<GatewayPayment> gatewayPayments = new ArrayList<>();

        // Iterar sobre el iterable y agregar los elementos a la lista
        for (GatewayPayment gatewayPayment : iterable) {
            gatewayPayments.add(gatewayPayment);
        }

        return gatewayPayments;
    }
}
