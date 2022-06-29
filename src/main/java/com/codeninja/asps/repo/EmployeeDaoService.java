package com.codeninja.asps.repo;

import com.codeninja.asps.config.EmployeeRowMapper;
import com.codeninja.asps.models.Employee;
import com.codeninja.asps.models.Salary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoService implements EmployeeDAO {
    private final JdbcTemplate jdbcTemplate;

    private final EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();

    public EmployeeDaoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }


    @SuppressWarnings("SqlInsertValues")
    @Override
    public Employee addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (fullname, email, bankdetails, salary) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, employee.getFullname(), employee.getEmail(), employee.getBankDetails(), employee.getSalary());
        return employee;
    }

    @Override
    public void removeEmployee(Employee employee) {
        String sql = "DELETE FROM employees WHERE id = ?";
        jdbcTemplate.update(sql, employee.getEmployeeId());

    }

    @Override
    public Employee updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET fullname = ?, email = ?, bankdetails = ?, salary = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getFullname(), employee.getEmail(), employee.getBankDetails(), employee.getSalary(), employee.getEmployeeId());
        return employee;
    }

    @Override
    public Employee getEmployee(long id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, employeeRowMapper, id);

    }

    @Override
    public Iterable<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, employeeRowMapper);

    }

    @Override
    public void addSalary(Salary salary, Employee employee) {
        String sql = "INSERT INTO employees (id, salary) VALUES (?, ?)";
        jdbcTemplate.update(sql, employee.getEmployeeId(), salary.getAmount());

    }

    @Override
    public Iterable<Employee> getEmployeeLevels() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, employeeRowMapper);
    }

    @Override
    public void createSalaryTable() {
        String sql = "CREATE TABLE salaries (id SERIAL PRIMARY KEY, employee_id INTEGER, salary INTEGER)";
        jdbcTemplate.execute(sql);
    }

    @Override
    public Iterable<Employee> getEmployeesAndSalaries() {
        String sql = "SELECT * FROM employees JOIN salaries ON employees.id = salaries.employee_id";
        return jdbcTemplate.query(sql, employeeRowMapper);
    }
}
