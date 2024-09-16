package com.udea.modulo_pagos.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private LocalDate date;
    private int total_price;
    private Float additional_charge;

    @ManyToOne
    @JoinColumn(name="id", nullable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name="id", nullable = false)
    private Payment payment_method;

    public Transaction(Long id, String status, LocalDate date, int total_price, Float additional_charge, Long booking_id, Long payment_method_id) {
        this.id = id;
        this.status = status;
        this.date = date;
        this.total_price = total_price;
        this.additional_charge = additional_charge;
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

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public Float getAdditional_charge() {
        return additional_charge;
    }

    public void setAdditional_charge(Float additional_charge) {
        this.additional_charge = additional_charge;
    }
}
