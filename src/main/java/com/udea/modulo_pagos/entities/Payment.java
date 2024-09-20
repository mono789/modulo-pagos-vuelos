package com.udea.modulo_pagos.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payment_id;
    private LocalDate date;
    private Float total_paid;
    private String paymentStatus;

    public Payment(){}

    public Payment(Long payment_id, LocalDate date, Float total_paid, String paymentStatus, Transaction transaction, GatewayPayment gatewayPayment) {
        this.payment_id = payment_id;
        this.date = date;
        this.total_paid = total_paid;
        this.paymentStatus = paymentStatus;
        this.transaction = transaction;
        this.gatewayPayment = gatewayPayment;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @ManyToOne
    @JoinColumn(name="transaction_id", nullable = false)
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name="gateway_payment_id", nullable = false)
    private GatewayPayment gatewayPayment ;

    public Long getId() {
        return payment_id;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public GatewayPayment getGatewayPayment() {
        return gatewayPayment;
    }

    public void setGatewayPayment(GatewayPayment gatewayPayment) {
        this.gatewayPayment = gatewayPayment;
    }

    public void setId(Long payment_id) {
        this.payment_id = payment_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Float getTotal_paid() {
        return total_paid;
    }

    public void setTotal_paid(Float total_paid) {
        this.total_paid = total_paid;
    }
}
