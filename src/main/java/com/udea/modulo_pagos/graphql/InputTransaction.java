package com.udea.modulo_pagos.graphql;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InputTransaction {

    private String status;
    private LocalDate date;
    private int total_price;
    private Float additional_charge;

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
