package com.codeninja.asps.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee{

    private long id;
    private String Fullname;
    private String Email;
    private BankDetails BankDetails;
    private Salary Salary;


    public Employee() {
        this.id = id++;
        this.Fullname = Fullname;
        this.Email = Email;
    }
}
