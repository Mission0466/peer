package org.example.springemployee.Rest;

import org.example.springemployee.Entity.Employee;
import org.example.springemployee.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

  private EmployeeService employeeService;

  //constructor
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){  // constructor injection

        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){

        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("Employee ID not found" + employeeId);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee){
        Employee em = employeeService.save(theEmployee);
        return em;
    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteById(@PathVariable int employeeId){
        Employee em = employeeService.findById(employeeId);

        if(em == null){
            throw new RuntimeException("Employee ID is not present in DB - " + employeeId );
        }
        employeeService.deleteById(employeeId);
        return ("Deleted employee ID -" + employeeId);
    }

    // for update:
    // 1. find the ID
    // 2. update the data in DB
    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee updateEmp = employeeService.save(theEmployee);
        return updateEmp;
    }

}
