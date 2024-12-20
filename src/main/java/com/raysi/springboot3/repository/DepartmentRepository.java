package com.raysi.springboot3.repository;

import com.raysi.springboot3.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
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
}