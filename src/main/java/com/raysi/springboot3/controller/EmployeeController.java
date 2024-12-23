package com.raysi.springboot3.controller;

import com.raysi.springboot3.entity.Employee;
import com.raysi.springboot3.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/api/employee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("api/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/api/employee")
    public String saveEmployee(@Valid @RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee.toString();
    }
    @PostMapping("/api/employees")
    public String saveEmployees(@Valid @RequestBody List<Employee> employees){
        employeeService.saveEmployees(employees);
        return employees.toString();
    }

    @PutMapping("/api/employee/{id}")
    public String updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
        employeeService.updateEmployee(id, employee);
        return employee.toString();
    }

    @DeleteMapping("/api/employee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        return "The employee with id : " + id + " has been deleted!";
    }
}
