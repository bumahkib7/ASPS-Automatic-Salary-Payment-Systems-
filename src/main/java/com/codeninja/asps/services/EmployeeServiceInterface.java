package com.codeninja.asps.services;

import com.codeninja.asps.models.BankDetails;
import com.codeninja.asps.models.Employee;
import com.codeninja.asps.models.Salary;

public interface EmployeeServiceInterface {

    void payEmployee(Employee employee);


    void revokePayment(Employee employee);

    void askForEmployeeBankDetails(Employee employee);

    //

}
