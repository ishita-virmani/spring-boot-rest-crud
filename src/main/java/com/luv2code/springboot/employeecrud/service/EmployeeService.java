package com.luv2code.springboot.employeecrud.service;

import com.luv2code.springboot.employeecrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    //get single employee by Id
    Employee findById(int id);

    //Save new employee/ update existing employee
    Employee save(Employee employee);

    //Delete an existing employee
    void deleteById(int id);

}
