package org.example.springemployee.Services;

import jakarta.transaction.Transactional;
import org.example.springemployee.DAO.EmployeeDAO;
import org.example.springemployee.DAO.EmployeeDAOImpl;
import org.example.springemployee.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    public EmployeeDAO employeeDAO; // always use the interface name not the class name like EmployeeDAOImpl here

    public EmployeeServiceImpl(EmployeeDAO employeeDAO){

        this.employeeDAO = employeeDAO;
    }
    @Override
    public List<Employee> findAll() {

        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findByID(id);
    }

    @Transactional  // use this keyword to perform operations in DB
    @Override
    public Employee save(Employee theEmployee) {
        Employee em = employeeDAO.save(theEmployee);
        return em;
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }


}
