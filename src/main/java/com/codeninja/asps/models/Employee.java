package com.codeninja.asps.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class Employee{

    private  long EmployeeId;
    private String Fullname;
    private String Email;
    private BankDetails BankDetails;
    private Salary Salary;


    public Employee() {
        EmployeeId++;
        this.Fullname = Fullname;
        this.Email = Email;
    }






}
