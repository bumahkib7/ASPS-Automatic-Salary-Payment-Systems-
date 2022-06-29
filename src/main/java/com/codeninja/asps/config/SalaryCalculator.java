package com.codeninja.asps.config;

import com.codeninja.asps.models.BonusAccordingToEmployeeLevel;
import com.codeninja.asps.models.EmployeeLevel;
import com.codeninja.asps.models.Salary;
import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;

@Configuration
public class SalaryCalculator {

    private final Salary salary;
    private final EmployeeLevel employeeLevel;

    private  final int hourlyWage;
    private final int hoursWorked;

    private final BigInteger salaryAmount;
    private final BonusEligibilityCheck bonusEligibilityCheck;


    public SalaryCalculator(Salary salary, EmployeeLevel employeeLevel, int hourlyWage, int hoursWorked, BonusAccordingToEmployeeLevel bonusAccordingToEmployeeLevel, BigInteger salaryAmount, BonusEligibilityCheck bonusEligibilityCheck) {
        this.salary = salary;
        this.employeeLevel = employeeLevel;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
        this.salaryAmount = salaryAmount;
        this.bonusEligibilityCheck = bonusEligibilityCheck;
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