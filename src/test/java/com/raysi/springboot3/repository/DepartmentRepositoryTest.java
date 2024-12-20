package com.raysi.springboot3.repository;

import com.raysi.springboot3.entity.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

// @SpringBootTest is used to load the full application context for integration testing.
// This annotation ensures that the test runs in a Spring container with all beans initialized.
@SpringBootTest
class DepartmentRepositoryTest {

    // Declares a final field for DepartmentRepository to ensure immutability and proper dependency injection.
    private final DepartmentRepository departmentRepository;

    // Constructor-based dependency injection for DepartmentRepository.
    // This is preferred as it makes dependencies explicit and allows for better testing and immutability.
    @Autowired
    public DepartmentRepositoryTest(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // @Test annotation marks this method as a test case to be executed by JUnit.
    @Test
    public void saveTest() {
        // Creates a new Department object using the builder pattern.
        // The builder pattern is used to create objects with multiple parameters in a readable and concise manner.
        Department department = Department.builder()
                .departmentName("Management")   // Sets the name of the department.
                .departmentAddress("Hile")      // Sets the address of the department.
                .departmentCode("116")          // Sets the unique code for the department.
                .build();                       // Finalizes the object creation.

        // Saves the created department object into the database.
        // This is a test to verify that the save operation works as expected with the repository.
        departmentRepository.save(department);
    }
}