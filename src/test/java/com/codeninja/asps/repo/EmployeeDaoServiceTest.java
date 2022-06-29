package com.codeninja.asps.repo;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.codeninja.asps.models.Employee;
import com.codeninja.asps.models.Salary;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmployeeDaoService.class, Employee.class})
@ExtendWith(SpringExtension.class)
class EmployeeDaoServiceTest {
    @MockBean
    private Salary salary;

    @Autowired
    private Employee employee;

    @Autowired
    private EmployeeDaoService employeeDaoService;

    @MockBean
    private JdbcTemplate jdbcTemplate;

    /**
     * Method under test: {@link EmployeeDaoService#addEmployee(Employee)}
     */
    @Test
    void testAddEmployee() throws DataAccessException {
        when(jdbcTemplate.update((String) any(), (Object[]) any())).thenReturn(1);
        employeeDaoService.addEmployee(employee);
        verify(jdbcTemplate).update((String) any(), (Object[]) any());
    }

    /**
     * Method under test: {@link EmployeeDaoService#removeEmployee(Employee)}
     */
    @Test
    void testRemoveEmployee() throws DataAccessException {
        when(jdbcTemplate.update((String) any(), (Object[]) any())).thenReturn(1);
        employeeDaoService.removeEmployee(employee);
        verify(jdbcTemplate).update((String) any(), (Object[]) any());
    }

    /**
     * Method under test: {@link EmployeeDaoService#updateEmployee(Employee)}
     */
    @Test
    void testUpdateEmployee() throws DataAccessException {
        when(jdbcTemplate.update((String) any(), (Object[]) any())).thenReturn(1);
        employeeDaoService.updateEmployee(employee);
        verify(jdbcTemplate).update((String) any(), (Object[]) any());
    }

    /**
     * Method under test: {@link EmployeeDaoService#getEmployee(long)}
     */
    @Test
    void testGetEmployee() throws DataAccessException {
        Employee employee = new Employee();
        when(jdbcTemplate.queryForObject((String) any(), (RowMapper<Employee>) any(), (Object[]) any()))
                .thenReturn(employee);
        assertSame(employee, employeeDaoService.getEmployee(123L));
        verify(jdbcTemplate).queryForObject((String) any(), (RowMapper<Employee>) any(), (Object[]) any());
    }

    /**
     * Method under test: {@link EmployeeDaoService#getAllEmployees()}
     */
    @Test
    void testGetAllEmployees() throws DataAccessException {
        ArrayList<Employee> employeeList = new ArrayList<>();
        when(jdbcTemplate.query((String) any(), (RowMapper<Employee>) any())).thenReturn(employeeList);
        Iterable<Employee> actualAllEmployees = employeeDaoService.getAllEmployees();
        assertSame(employeeList, actualAllEmployees);
        assertTrue(((Collection<Employee>) actualAllEmployees).isEmpty());
        verify(jdbcTemplate).query((String) any(), (RowMapper<Employee>) any());
    }

    /**
     * Method under test: {@link EmployeeDaoService#addSalary(Salary, Employee)}
     */
    @Test
    void testAddSalary() throws DataAccessException {
        when(jdbcTemplate.update((String) any(), (Object[]) any())).thenReturn(1);
        when(salary.getAmount()).thenReturn(BigInteger.valueOf(42L));
        employeeDaoService.addSalary(salary, employee);
        verify(jdbcTemplate).update((String) any(), (Object[]) any());
        verify(salary).getAmount();
    }

    /**
     * Method under test: {@link EmployeeDaoService#getEmployeeLevels()}
     */
    @Test
    void testGetEmployeeLevels() throws DataAccessException {
        ArrayList<Employee> employeeList = new ArrayList<>();
        when(jdbcTemplate.query((String) any(), (RowMapper<Employee>) any())).thenReturn(employeeList);
        Iterable<Employee> actualEmployeeLevels = employeeDaoService.getEmployeeLevels();
        assertSame(employeeList, actualEmployeeLevels);
        assertTrue(((Collection<Employee>) actualEmployeeLevels).isEmpty());
        verify(jdbcTemplate).query((String) any(), (RowMapper<Employee>) any());
    }

    /**
     * Method under test: {@link EmployeeDaoService#createSalaryTable()}
     */
    @Test
    void testCreateSalaryTable() throws DataAccessException {
        doNothing().when(jdbcTemplate).execute((String) any());
        employeeDaoService.createSalaryTable();
        verify(jdbcTemplate).execute((String) any());
    }

    /**
     * Method under test: {@link EmployeeDaoService#getEmployeesAndSalaries()}
     */
    @Test
    void testGetEmployeesAndSalaries() throws DataAccessException {
        ArrayList<Employee> employeeList = new ArrayList<>();
        when(jdbcTemplate.query((String) any(), (RowMapper<Employee>) any())).thenReturn(employeeList);
        Iterable<Employee> actualEmployeesAndSalaries = employeeDaoService.getEmployeesAndSalaries();
        assertSame(employeeList, actualEmployeesAndSalaries);
        assertTrue(((Collection<Employee>) actualEmployeesAndSalaries).isEmpty());
        verify(jdbcTemplate).query((String) any(), (RowMapper<Employee>) any());
    }
}

