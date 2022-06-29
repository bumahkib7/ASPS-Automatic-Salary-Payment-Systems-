package com.codeninja.asps.config;

import com.codeninja.asps.models.Salary;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SalaryCalculator {

    private final int hourlyWage;
    private final int hoursWorked;

    private final BigInteger salaryAmount;
    private final BonusEligibilityCheck bonusEligibilityCheck;


    public SalaryCalculator(int hourlyWage, int hoursWorked, BonusEligibilityCheck bonusEligibilityCheck) {
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
        this.bonusEligibilityCheck = bonusEligibilityCheck;
        this.salaryAmount = BigInteger.valueOf((long) hourlyWage * hoursWorked);
    }

    //create a function that calculates salary of the developers plus their bonus if they are eligible for it
    public Salary calculateSalary() {
        int salary = hourlyWage * hoursWorked;
        if (bonusEligibilityCheck.isBonusEligible(salary)) {
            salary += salary * bonusEligibilityCheck.getBonus();
        }
        return new Salary(BigInteger.valueOf(salary), salaryAmount.toString());
    }


}