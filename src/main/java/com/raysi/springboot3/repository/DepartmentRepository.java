package com.raysi.springboot3.repository;

import com.raysi.springboot3.entity.Department;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
}
