package com.udea.modulo_pagos.entities;

import jakarta.persistence.*;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import java.time.LocalDate;

@Entity
@Table(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private LocalDate date;
    private Float total_price;
    private Float additional_charge;

    @ManyToOne
    @JoinColumn(name="booking_id", nullable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name="payment_method_id", nullable = false)
    private PaymentMethod payment_method;

    public Transaction(Long id, String status, LocalDate date, Float total_price, Float additional_charge, Booking booking, PaymentMethod payment_method) {
        this.id = id;
        this.status = status;
        this.date = date;
        this.total_price = total_price;
        this.additional_charge = additional_charge;
        this.booking = booking;  // Relación con Booking
        this.payment_method = payment_method;  // Relación con Payment
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public PaymentMethod getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(PaymentMethod payment_method) {
        this.payment_method = payment_method;
    }

    public Transaction (){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Float total_price) {
        this.total_price = total_price;
    }

    public Float getAdditional_charge() {
        return additional_charge;
    }

    public void setAdditional_charge(Float additional_charge) {
        this.additional_charge = additional_charge;
    }
}
