package org.example.springemployee.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.springemployee.Entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // repository is nothing but a class that connects to DB
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager; // entity manager api in JPA // global


    public EmployeeDAOImpl(EntityManager entityManager){ // construction injection

        this.entityManager = entityManager;
    }

    // behind the scenes with main
//    public main (){
//        EntityManager em = new EntityManager();
//        EmployeeDAOImpl e = new EmployeeDAOImpl(em);
//    }
    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get the result set in List form
        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findByID(int id) {
        Employee e = entityManager.find(Employee.class, id);
        return e;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee em = entityManager.merge(theEmployee);  // if the record is not found in the DB it will create a new record. if the record is already exist in DB it will update
        return em;
    }

    @Override
    public void deleteById(int id) {

        // find that id is present in the DB or not
        Employee e = entityManager.find(Employee.class, id);
        entityManager.remove(e);
    }
}
