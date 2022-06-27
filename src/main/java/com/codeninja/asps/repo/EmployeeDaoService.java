package com.codeninja.asps.repo;

import com.codeninja.asps.models.Employee;
import com.codeninja.asps.models.Salary;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDaoService implements EmployeeDAO {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDaoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long getEmployeebyId(long id) {
        String sql = """
                SELECT * FROM employees WHERE id = ?
        """;
        return jdbcTemplate.update(sql, id);
    }

  @Override
    public Employee addEmployee(Employee employee) {
        String sql = """
                INSERT INTO employees (fullname, email, bankdetails, salary)
                VALUES (?, ?, ?, ?)
        """;
        jdbcTemplate.update(sql, employee.getFullname(), employee.getEmail(), employee.getBankDetails(), employee.getSalary());
        return employee;
    }
}
