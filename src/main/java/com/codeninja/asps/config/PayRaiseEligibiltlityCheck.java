package com.codeninja.asps.config;

import org.springframework.stereotype.Component;

@Component
public class PayRaiseEligibiltlityCheck {
    private final int payRaise;
    private final int salary;

    public PayRaiseEligibiltlityCheck(int payRaise, int salary) {
        this.payRaise = payRaise;
        this.salary = salary;
    }

    public boolean isPayRaiseEligible() {
        return salary >= payRaise;
    }


    //create a function that calculates the pay raise according to employee level
    public int calculatePayRaise() {
        return salary * payRaise;
    }


}
