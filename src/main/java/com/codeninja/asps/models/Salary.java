package com.codeninja.asps.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;
@Data
@AllArgsConstructor
public class Salary {


    private final String eur;
    private BigInteger amount;


    public Salary(BigInteger i,     String eur) {
        this.amount = i;
        this.eur = eur;
    }
}
