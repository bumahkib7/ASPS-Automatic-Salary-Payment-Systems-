package com.codeninja.asps.repo;

import com.codeninja.asps.models.Employee;
import com.codeninja.asps.models.Salary;

public interface EmployeeDAO {
    // create a method that adds am employee to the database
    Employee addEmployee(Employee employee);

    // create a method that removes an employee from the database
    void removeEmployee(Employee employee);

    // create a method that updates an employee in the database
    Employee updateEmployee(Employee employee);


    //create a method that returns an employee from the database
    Employee getEmployee(long id);

    //create a method that returns all employees from the database
    Iterable<Employee> getAllEmployees();


    //create a function that adds a salary to the employees' table where the employee id is the same as the salary employee id
    void addSalary(Salary salary, Employee employee);


    //create a method that groups employees by employee level and returns the count of employees in each level
    Iterable<Employee> getEmployeeLevels();

    // create a method that creates a new salary table
    void createSalaryTable();

    // create a method that performs a join between the employees and salaries tables and returns the employees and salaries
    Iterable<Employee> getEmployeesAndSalaries();
}
