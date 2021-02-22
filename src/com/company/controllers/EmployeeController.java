package com.company.controllers;

import com.company.entities.Employee;
import com.company.repositories.interfaces.IEmployeeRepository;

import java.util.List;

public class EmployeeController {
    private final IEmployeeRepository repo;



    public EmployeeController(IEmployeeRepository repo) {
        this.repo = repo;
    }

    public String createEmployee(String name, String surname, String gender, String mail, String jobPosition, int salary) {
        boolean male = (gender.toLowerCase().equals("male"));
        Employee employee = new Employee(name, surname, male, mail, jobPosition, salary);

        boolean created = repo.createUser(employee);

        return (created ? "Employee information has successfully saved!" : "Employee creation was failed!");
    }

    public String getEmployee(int id) {
        Employee employee = repo.getUser(id);

        return (employee == null ? "Employee was not found!" : employee.toString());
    }

    public String getAllEmployees() {
        List<Employee> employees = repo.getAllEmployees();
        return employees.toString();
    }
}