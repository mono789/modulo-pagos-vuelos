package com.udea.modulo_pagos.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private int total_paid;

    public Payment(){}
    public Payment(Long id, LocalDate date, Integer total_paid) {
        this.id = id;
        this.date = date;
        this.total_paid = total_paid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTotal_paid() {
        return total_paid;
    }

    public void setTotal_paid(int total_paid) {
        this.total_paid = total_paid;
    }
}
