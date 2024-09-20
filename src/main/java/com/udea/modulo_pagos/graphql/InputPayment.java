package com.udea.modulo_pagos.graphql;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InputPayment {
    private LocalDate date;
    private Integer total_paid;

    private Long transaction_id;  // Cambiado de Booking a Long para manejar el ID
    private Long gateway_payment_id;

    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Long getGateway_payment_id() {
        return gateway_payment_id;
    }

    public void setGateway_payment_id(Long gateway_payment_id) {
        this.gateway_payment_id = gateway_payment_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getTotal_paid() {
        return total_paid;
    }

    public void setTotal_paid(Integer total_paid) {
        this.total_paid = total_paid;
    }
}


