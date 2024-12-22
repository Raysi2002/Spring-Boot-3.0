package com.raysi.springboot3.repository;

import com.raysi.springboot3.entity.Department;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository annotation marks this interface as a Spring-managed bean and a Data Access Object (DAO).
// It indicates that this interface is responsible for interacting with the database for the Department entity.
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // This interface extends JpaRepository, which provides built-in CRUD operations for the Department entity.
    // JpaRepository is a Spring Data JPA interface that comes with several pre-implemented methods such as save, findById, findAll, delete, etc.

    // Generic Parameters:
    // - Department: The entity type that this repository will manage.
    // - Long: The data type of the primary key (departmentId) in the Department entity.

    // No additional methods are defined here because JpaRepository already provides all the basic functionality required
    // to interact with the database. Custom queries can be added as needed using method names or @Query annotations.
    // @Modifying annotation indicates that the query modifies the database (e.g., DELETE, UPDATE, INSERT).
// This is necessary because @Query by default assumes SELECT queries.
    @Modifying

// @Transactional annotation ensures that this method is executed within a transaction.
// If an error occurs, the transaction is rolled back to maintain data integrity.
    @Transactional

// @Query annotation defines a custom query to delete a department by its ID using a native SQL query.
// The ?1 placeholder represents the first parameter (departmentId) passed to the method.
    @Query(value = "DELETE FROM department WHERE department_id = ?1", nativeQuery = true)

// Method definition to delete a department by its ID from the database.
// It uses the departmentId as a parameter to identify the record to be deleted.
    void deleteDepartmentByDepartmentId(Long departmentId);

    // Method 1: Fetch all departments by department name using a native query
    @Query(value = "SELECT * FROM department where department_name = ?1", nativeQuery = true)
    List<Department> findAllByDepartmentName(String departmentName);
// This method executes a native SQL query to fetch all departments matching the given department name.
// Use Case: Ideal when working directly with SQL for flexibility or performance optimization.
// Key Points:
// - `?1` refers to the first parameter (departmentName) passed to the query.
// - Returns a list of Department objects, assuming multiple entries with the same name may exist.
// - Native queries bypass JPA/Hibernate's abstraction, giving more control but less portability.
// Example Usage:
//   List<Department> departments = repository.findAllByDepartmentName("Finance");
//   Retrieves all departments named "Finance" from the database.


    // Method 2: Fetch a single department by department name, case-insensitive
    Department findByDepartmentNameIgnoreCase(String departmentName);
// This method uses JPA's method naming convention to perform a case-insensitive search by department name.
// Use Case: Ideal for fetching a single department where the name is unique, ignoring case sensitivity.
// Key Points:
// - No custom query is required; JPA generates the query automatically based on the method name.
// - Returns a single Department object, assuming department names are unique.
// - Case-insensitivity is built-in, ensuring results are matched regardless of the input's case.
// Example Usage:
//   Department department = repository.findByDepartmentNameIgnoreCase("finance");
//   Retrieves the department named "Finance" or "FINANCE" or any other case variation.


}
