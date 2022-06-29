package com.codeninja.asps.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Salary {


    String eur;
    BigInteger amount;
    private boolean paid;


    public Salary(BigInteger i, String eur) {
        this.amount = i;
        this.eur = eur;
    }

    public Salary(int salary, int bonus) {
        this.amount = BigInteger.valueOf(salary);
        this.eur = "EUR";
    }


    public BigInteger getAmount() {
        return amount;
    }

    public void setPaid(boolean b) {
        this.paid = b;

    }
}
