package com.codeninja.asps.models;

import com.codeninja.asps.config.BonusEligibilityCheck;
import com.codeninja.asps.config.SalaryCalculator;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
@Data
@AllArgsConstructor
@Component
public class Salary {


    String eur;
    BigInteger amount;
    private boolean paid;



    public Salary(BigInteger i,     String eur) {
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
