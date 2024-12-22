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

    // This method fetches a department by its ID from the database.
// It abstracts the data-fetching logic and provides the required department to the controller.
    Department fetchDepartmentById(Long id);

    // This method deletes a department by its ID using a custom query method from the repository.
// It handles the logic for removing a department record from the database.
    void deleteDepartmentById(Long id);

    // This method deletes a department by its ID using JPA's built-in deleteById method.
// It provides an alternative approach for removing department records from the database.
    void deleteDepartmentByIdJpaMethod(Long id);

    // This method updates an existing department by its ID with new values provided in the department parameter.
// It ensures that only valid fields are updated and handles the persistence of changes.
    Department updateDepartment(Long id, Department department);

    // Method 1: Fetch all departments by department name (case-sensitive)
    List<Department> fetchDepartmentByDeptName(String deptName);
// This method retrieves a list of departments that match the given department name.
// Use Case: Ideal when multiple departments with the same name might exist.
// Key Points:
// - Case-sensitive search: The input `deptName` must exactly match the department name in the database.
// - Returns a list of Department objects, assuming there could be multiple matches.
// - Typically implemented using JPA or Hibernate's query methods.
// Example Usage:
//   List<Department> departments = service.fetchDepartmentByDeptName("Finance");
//   Retrieves all departments with the exact name "Finance".


    // Method 2: Fetch a single department by department name using a native query
    Department fetchDepartmentByDeptNameNative(String deptName);
// This method retrieves a single department by its name using a native SQL query.
// Use Case: Ideal when department names are unique and native SQL queries are preferred for optimization.
// Key Points:
// - Native SQL query implementation for better control and performance.
// - Assumes department names are unique, returning a single Department object.
// - Case sensitivity depends on how the query is written (e.g., may require `LOWER()` for case-insensitivity).
// Example Usage:
//   Department department = service.fetchDepartmentByDeptNameNative("HR");
//   Retrieves the unique department with the exact name "HR".
}