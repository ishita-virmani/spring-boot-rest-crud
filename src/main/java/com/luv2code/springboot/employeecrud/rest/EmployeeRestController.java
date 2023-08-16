package com.luv2code.springboot.employeecrud.rest;

import com.luv2code.springboot.employeecrud.dao.EmployeeDAO;
import com.luv2code.springboot.employeecrud.entity.Employee;
import com.luv2code.springboot.employeecrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theemployeeservice){
        employeeService = theemployeeservice;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee= employeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee Id not found -"+employeeId);
        }
        return employee;
    }

    //Add new Employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    //Update an existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee==null){
            throw new RuntimeException("Employee id not found -"+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee Id:" + employeeId;
    }
}
