package com.udea.modulo_pagos.graphql;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InputPayment {
    private LocalDate date;
    private Integer total_paid;

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


