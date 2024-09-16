package com.udea.modulo_pagos.entities;

import jakarta.persistence.*;

@Entity
@Table(name="flight")
public class Flitght {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
