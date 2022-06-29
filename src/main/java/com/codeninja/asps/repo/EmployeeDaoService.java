package com.codeninja.asps.repo;

import com.codeninja.asps.config.EmployeeRowMapper;
import com.codeninja.asps.models.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoService implements EmployeeDAO {
    private JdbcTemplate jdbcTemplate;

    private EmployeeRowMapper employeeRowMapper;

    @Override
    public long getEmployeebyId(long id) {
        var sql = "SELECT * FROM employees WHERE id = ?";
        return jdbcTemplate.update(sql, new Object[]{id}, new EmployeeRowMapper();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        var sql = """
                INSERT INTO employees (id ,fullname, email, bankdetails, salary) VALUES (?, ?, ?, ?)
                """;
        return jdbcTemplate.update(sql, new EmployeeRowMapper());
    }
}
