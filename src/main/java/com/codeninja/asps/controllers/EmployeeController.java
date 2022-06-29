package com.codeninja.asps.controllers;

import com.codeninja.asps.models.Employee;
import com.codeninja.asps.repo.EmployeeDaoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeDaoService employeeDaoService;

    public EmployeeController(EmployeeDaoService employeeDaoService) {
        this.employeeDaoService = employeeDaoService;
    }

    @PostMapping("/add")
    public Employee addEmployee(Employee employee) {
        return employeeDaoService.addEmployee(employee);
    }

}
