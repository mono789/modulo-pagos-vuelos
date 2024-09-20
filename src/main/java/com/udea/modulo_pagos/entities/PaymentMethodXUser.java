package com.udea.modulo_pagos.entities;

import jakarta.persistence.*;

@Entity
@Table(name="payment_method_user")
public class PaymentMethodXUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String card_number;
    private String card_type;
    private String expiry_date;
    private String ccv;
    private String last4Digits;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="payment_method_id", nullable = false)
    private PaymentMethod payment_method;

    public PaymentMethodXUser() {
    }

    public PaymentMethodXUser(String card_number, String card_type, String expiry_date, String ccv, String last4Digits, User user, PaymentMethod payment_method) {
        this.card_number = card_number;
        this.card_type = card_type;
        this.expiry_date = expiry_date;
        this.ccv = ccv;
        this.last4Digits = last4Digits;
        this.user = user;
        this.payment_method = payment_method;
    }

    public String getLast4Digits() {
        return last4Digits;
    }

    public void setLast4Digits(String last4Digits) {
        this.last4Digits = last4Digits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PaymentMethod getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(PaymentMethod payment_method) {
        this.payment_method = payment_method;
    }
}
