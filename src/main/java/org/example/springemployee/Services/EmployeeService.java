package org.example.springemployee.Services;

import org.example.springemployee.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    public Employee findById(int id);

    public Employee save(Employee theEmployee);

    public void deleteById(int id);
}
