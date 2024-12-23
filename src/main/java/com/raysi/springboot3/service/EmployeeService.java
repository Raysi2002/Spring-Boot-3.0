package com.raysi.springboot3.service;

import com.raysi.springboot3.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployee();
    Employee getEmployeeById(Long id);
    void saveEmployee(Employee employee);
    void saveEmployees(List<Employee> employees);
    void updateEmployee(Long id, Employee employee);
    void deleteEmployeeById(Long id);
}
