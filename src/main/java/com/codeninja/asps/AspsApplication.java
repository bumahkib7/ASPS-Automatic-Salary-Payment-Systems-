package com.codeninja.asps;

import com.codeninja.asps.models.BankDetails;
import com.codeninja.asps.models.Employee;
import com.codeninja.asps.models.Salary;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigInteger;

@SpringBootApplication
public class AspsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AspsApplication.class, args);
    }


    CommandLineRunner runner = (args) -> {
        Employee employee = new Employee();
        employee.setFullname("John Doe");
        employee.setEmail("johndoe1@gmail.com");
        employee.setBankDetails(new BankDetails("Sparkasse", "DE23_123434 323", "Koln bonn", "COLSDE1234"));
        employee.setSalary(new Salary(BigInteger.valueOf(100000), "EUR"));
    };

}
