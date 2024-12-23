package com.raysi.springboot3.controller;

import com.raysi.springboot3.entity.Employee;
import com.raysi.springboot3.service.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/api/employee")
    public List<Employee> getAllEmployee(){
        logger.info("Employee data is fetched ");
        return employeeService.getAllEmployee();
    }

    @GetMapping("api/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        logger.info("Employee with id : {} is fetched", id);
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/api/employee")
    public String saveEmployee(@Valid @RequestBody Employee employee){
        logger.info("Employee : {} is saved", employee);
        employeeService.saveEmployee(employee);
        return employee.toString();
    }
    @PostMapping("/api/employees")
    public String saveEmployees(@Valid @RequestBody List<Employee> employees){
        logger.info("Multiple employee has been saved");
        employeeService.saveEmployees(employees);
        return employees.toString();
    }

    @PutMapping("/api/employee/{id}")
    public String updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
        logger.info("Employee with id : {} has been updated", id);
        employeeService.updateEmployee(id, employee);
        return employee.toString();
    }

    @DeleteMapping("/api/employee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        logger.info("Employee with id : {} has been deleted", id);
        employeeService.deleteEmployeeById(id);
        return "The employee with id : " + id + " has been deleted!";
    }
}
