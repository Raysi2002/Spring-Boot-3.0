package com.raysi.springboot3.service;

import java.util.List;
import com.raysi.springboot3.entity.Department;
import org.springframework.stereotype.Service;

// @Service annotation marks this interface as part of the service layer in the Spring application.
// The service layer contains business logic and acts as a bridge between the controller and repository layers.
@Service
public interface DepartmentService {

    // Method to fetch all departments from the database.
    // This abstracts the data-fetching logic from the controller, ensuring separation of concerns.
    List<Department> fetchDepartments();

    // Method to save a department entity to the database.
    // The implementation of this method will handle any necessary validation or business logic before saving.
    void saveDepartment(Department department);


    // This method is designed to save multiple Department entities in a single operation.

    // Parameters:
    // - List<Department> departments: A list of Department objects to be persisted to the database.
    //   The list is typically provided by the controller after receiving a batch request from the client.

    // Responsibilities:
    // - Defines the contract for saving a list of Department entities.
    // - The actual implementation of this method will be provided in the implementing class (e.g., DepartmentServiceImplementation).

    // Use Case:
    // - Useful for batch processing where multiple department records need to be saved at once.
    // - Reduces the overhead of making multiple individual save calls for each department.
    void saveDepartments(List<Department> departments);

    Department fetchDepartmentById(Long id);

    void deleteDepartmentById(Long id);

    void deleteDepartmentByIdJpaMethod(Long id);

    Department updateDepartment(Long id, Department department);
}