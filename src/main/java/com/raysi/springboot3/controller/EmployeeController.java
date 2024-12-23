package com.raysi.springboot3.controller;

import com.raysi.springboot3.entity.Employee; // Employee entity class.
import com.raysi.springboot3.service.EmployeeService; // Employee service interface for business logic.
import jakarta.validation.Valid; // For validating request bodies.
import org.slf4j.Logger; // SLF4J Logger for logging.
import org.slf4j.LoggerFactory; // Factory for creating loggers.
import org.springframework.beans.factory.annotation.Autowired; // For constructor-based dependency injection.
import org.springframework.web.bind.annotation.*; // Annotations for defining REST endpoints.

import java.util.List; // List of employees.

@RestController // Marks this class as a REST controller that returns data directly to the client.
public class EmployeeController {

    // Logger to log information, errors, or other details.
    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    // Injecting EmployeeService to access the business logic methods.
    private final EmployeeService employeeService;

    // Constructor-based dependency injection.
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Endpoint to get all employees.
    @GetMapping("/api/employee")
    public List<Employee> getAllEmployee() {
        // Log the request to fetch employee data.
        logger.info("Employee data is fetched ");
        // Call service method to fetch all employees.
        return employeeService.getAllEmployee();
    }

    // Endpoint to get a single employee by ID.
    @GetMapping("api/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        // Log the request to fetch employee by ID.
        logger.info("Employee with id : {} is fetched", id);
        // Call service method to fetch employee by ID.
        return employeeService.getEmployeeById(id);
    }

    // Endpoint to save a single employee.
    @PostMapping("/api/employee")
    public String saveEmployee(@Valid @RequestBody Employee employee) {
        // Log the request to save employee.
        logger.info("Employee : {} is saved", employee);
        // Call service method to save the employee.
        employeeService.saveEmployee(employee);
        // Return a response with the employee details.
        return employee.toString();
    }

    // Endpoint to save multiple employees.
    @PostMapping("/api/employees")
    public String saveEmployees(@Valid @RequestBody List<Employee> employees) {
        // Log the request to save multiple employees.
        logger.info("Multiple employee has been saved");
        // Call service method to save multiple employees.
        employeeService.saveEmployees(employees);
        // Return a response with the list of employees saved.
        return employees.toString();
    }

    // Endpoint to update an existing employee.
    @PutMapping("/api/employee/{id}")
    public String updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        // Log the request to update employee by ID.
        logger.info("Employee with id : {} has been updated", id);
        // Call service method to update the employee.
        employeeService.updateEmployee(id, employee);
        // Return a response with the updated employee details.
        return employee.toString();
    }

    // Endpoint to delete an employee by ID.
    @DeleteMapping("/api/employee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        // Log the request to delete employee by ID.
        logger.info("Employee with id : {} has been deleted", id);
        // Call service method to delete the employee.
        employeeService.deleteEmployeeById(id);
        // Return a confirmation message that the employee has been deleted.
        return "The employee with id : " + id + " has been deleted!";
    }
}