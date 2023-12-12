package com.exemple.aksiomatik.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int a;
    private int b;
    private int c;
    private double x1;
    private double x2;

    public Parameter(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
