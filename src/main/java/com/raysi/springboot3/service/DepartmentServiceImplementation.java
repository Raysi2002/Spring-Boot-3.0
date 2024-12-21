package com.raysi.springboot3.service;

import com.raysi.springboot3.entity.Department;
import com.raysi.springboot3.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

// @Service annotation marks this class as a service component in the Spring application.
// It implements the business logic defined in the DepartmentService interface.
@Service
public class DepartmentServiceImplementation implements DepartmentService {

    // Declaring a final DepartmentRepository to ensure immutability and safe multi-threaded access.
    private final DepartmentRepository departmentRepository;

    // Constructor-based Dependency Injection is used here.
    // Spring automatically injects the required DepartmentRepository bean at runtime.
    @Autowired
    public DepartmentServiceImplementation(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // Implementation of the fetchDepartments method from the DepartmentService interface.
    // This method retrieves all Department entities from the database using the repository's findAll() method.
    @Override
    public List<Department> fetchDepartments() {
        return departmentRepository.findAll();
    }

    // Implementation of the saveDepartment method from the DepartmentService interface.
    // This method saves a Department entity to the database using the repository's save() method.
    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    /**
     * Implementation of the saveDepartments method defined in the DepartmentService interface.
     *
     * Responsibilities:
     * - Saves a list of Department entities to the database in a single operation.
     * - Utilizes the `saveAll` method provided by Spring Data JPA for batch saving.
     *
     * Parameters:
     * - List<Department> departments: The list of Department objects to be persisted.
     *
     * Key Points:
     * - The @Override annotation ensures that this method correctly overrides the interface method.
     * - The `saveAll` method optimizes batch operations by reducing the number of database interactions.
     *
     * Use Case:
     * - Useful for handling bulk save requests, improving performance and reducing the complexity
     *   of saving multiple entities individually.
     */
    @Override
    public void saveDepartments(List<Department> departments) {
        departmentRepository.saveAll(departments);
    }

    @Override
    public Department fetchDepartmentById(Long id){
        return departmentRepository.findById(id).get();
    }
}