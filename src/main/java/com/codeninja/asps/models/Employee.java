package com.codeninja.asps.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Employee{

    private  long EmployeeId;
    private String Fullname;
    private String Email;
    private BankDetails BankDetails;
    private Salary Salary;
}
