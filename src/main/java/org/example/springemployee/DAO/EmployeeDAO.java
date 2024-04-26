package org.example.springemployee.DAO;

import org.example.springemployee.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();

   public  Employee findByID(int id);

   public Employee save(Employee theEmployee);

   public void deleteById(int id);
}
