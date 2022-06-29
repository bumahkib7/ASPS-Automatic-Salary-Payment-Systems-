package com.codeninja.asps.config;

import com.codeninja.asps.models.BankDetails;
import com.codeninja.asps.models.Employee;
import com.codeninja.asps.models.Salary;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class EmployeeRowMapper implements RowMapper<Employee> {


    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(
                rs.getLong("id"),
                rs.getString("fullname"),
                rs.getString("email"),
                (BankDetails) rs.getObject("bankdetails"),
                (Salary) rs.getObject("salary")
        );


    }


}
                

