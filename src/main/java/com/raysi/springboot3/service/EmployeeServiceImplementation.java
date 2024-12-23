package com.raysi.springboot3.service;

// Service Implementation: EmployeeServiceImplementation
// This class provides the business logic for managing employees.

import com.raysi.springboot3.entity.Employee; // Entity class for employees.
import com.raysi.springboot3.repository.EmployeeRepository; // Repository interface for database operations.
import lombok.extern.slf4j.Slf4j; // Lombok annotation for logging.
import org.springframework.stereotype.Service; // Marks this class as a service component.

import java.util.List; // Used for handling lists of employees.
import java.util.Objects; // Utility class for null-safe checks.

@Slf4j // Lombok annotation: Automatically adds a logger to the class.
@Service // Marks this class as a service in the Spring application context.
public class EmployeeServiceImplementation implements EmployeeService {

    // Dependency Injection for the EmployeeRepository.
    private final EmployeeRepository employeeRepository;

    // Constructor-based injection ensures `employeeRepository` is provided.
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployee() {
        // Fetches all employees from the database.
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        // Fetches an employee by ID.
        // Uses `.get()` to directly retrieve the optional value.
        return employeeRepository.findById(id).get();
    }

    @Override
    public void saveEmployee(Employee employee) {
        // Saves a single employee to the database.
        employeeRepository.save(employee);
    }

    @Override
    public void saveEmployees(List<Employee> employees) {
        // Saves a list of employees to the database.
        employeeRepository.saveAll(employees);
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        // Logs the attempt to update an employee.
        log.info("Trying to update employee for employee id {}", id);

        // Fetches the existing employee by ID.
        Employee emp = employeeRepository.findById(id).get();

        // Updates fields only if they are non-null and not empty:
        if (Objects.nonNull(employee.getName()) && !"".equalsIgnoreCase(employee.getName())) {
            emp.setName(employee.getName());
        }

        if (Objects.nonNull(employee.getEmail()) && !"".equalsIgnoreCase(employee.getEmail())) {
            emp.setEmail(employee.getEmail());
        }

        if (Objects.nonNull(employee.getAge()) && !"".equalsIgnoreCase(String.valueOf(employee.getAge()))) {
            emp.setAge(employee.getAge());
        }

        if (Objects.nonNull(employee.getPhoneNo()) && !"".equalsIgnoreCase(employee.getPhoneNo())) {
            emp.setPhoneNo(employee.getPhoneNo());
        }

        // Saves the updated employee back to the database.
        employeeRepository.save(emp);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        // Deletes an employee by ID from the database.
        employeeRepository.deleteById(id);
    }
}