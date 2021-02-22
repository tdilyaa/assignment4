package com.company.repositories.interfaces;

import com.company.entities.Employee;

import java.util.List;

public interface IEmployeeRepository {
    boolean createUser(Employee employee);
    Employee getUser(int id);
    List<Employee> getAllEmployees();

    List<Employee> getAllUsers();
}







   