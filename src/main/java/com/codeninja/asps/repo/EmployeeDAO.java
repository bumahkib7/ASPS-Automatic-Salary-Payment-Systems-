package com.codeninja.asps.repo;

import com.codeninja.asps.models.Employee;

public interface EmployeeDAO {

    public long getEmployeebyId(long id);

    public Employee addEmployee(Employee employee);

}
