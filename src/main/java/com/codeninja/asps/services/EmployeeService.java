package com.codeninja.asps.services;

import com.codeninja.asps.models.BankDetails;
import com.codeninja.asps.models.Employee;
import com.codeninja.asps.models.Salary;
import com.codeninja.asps.repo.EmployeeDaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Optional;

public class EmployeeService implements EmployeeServiceInterface {

    private final EmployeeDaoService employeeDaoService;

    Logger log = LoggerFactory.getLogger(EmployeeService.class);
    public EmployeeService(EmployeeDaoService employeeDaoService) {
        this.employeeDaoService = employeeDaoService;
    }

    @Override
    public void payEmployee(Employee employee) {
        log.info("Paying employee");
        //pay the employee according to the salary calculator and employee level
       Optional<Salary> salary = Optional.ofNullable(employee.getSalary());
        assert Objects.requireNonNull(salary).isPresent();
        BigInteger salaryAmount = salary.get().getAmount();
        log.info("Paying employee with salary amount: " + salaryAmount);
        salary.get().setPaid(true);

        //ask for bank details if they are not present
        Optional<BankDetails> bankDetails = Optional.ofNullable(employee.getBankDetails());
        assert Objects.requireNonNull(bankDetails).isPresent();
        if (bankDetails.get().getAccountNumber() == null) {
            askForEmployeeBankDetails(employee);
        }

        //Make sure that the employee is paid
        assert salary.get().isPaid();
        assert bankDetails.get().getAccountNumber() != null;



    }

        @Override
         public void revokePayment(Employee employee) {
        log.info("Revoking payment for employee: {}", employee);

        //revoke the payment
        Optional<Salary> salary = Optional.ofNullable(employee.getSalary());
        assert Objects.requireNonNull(salary).isPresent();
        salary.get().setPaid(false);



    }

    @Override
    public void askForEmployeeBankDetails(Employee employee) {
        log.info("Asking for employee bank details: {}", employee);

    }

    }

