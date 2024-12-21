package com.raysi.springboot3.service;

import com.raysi.springboot3.entity.Department;
import com.raysi.springboot3.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

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

    // Fetches a Department entity by its ID.
    // If no entity is found, a NoSuchElementException is thrown.
    @Override
    public Department fetchDepartmentById(Long id){
        return departmentRepository.findById(id).get();
    }

    // Deletes a Department entity by its custom ID field (departmentId).
    // This uses a custom query defined in the DepartmentRepository.
    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteDepartmentByDepartmentId(id);
    }

    // Deletes a Department entity by its ID using the default JPA method.
    @Override
    public void deleteDepartmentByIdJpaMethod(Long id) {
        departmentRepository.deleteById(id);
    }

    /**
     * Updates a Department entity by its ID.
     *
     * Responsibilities:
     * - Fetches the existing entity from the database using its ID.
     * - Updates only the fields that are non-null and non-empty in the provided department object.
     * - Saves the updated entity back to the database.
     *
     * Parameters:
     * - Long id: The ID of the Department to update.
     * - Department department: The new data for updating the existing Department.
     *
     * Key Points:
     * - Uses `Objects.nonNull` to check for null values.
     * - Ensures that empty strings are not updated using `"".equalsIgnoreCase()`.
     */
    @Override
    public Department updateDepartment(Long id, Department department) {
        // Fetch the department to update, or throw an exception if not found.
        Department updatingDepartment = departmentRepository.findById(id).get();

        // Update the departmentName field if it's non-null and non-empty.
        //        Objects.nonNull(department.getDepartmentName()):
        //        Ensures the departmentName is not null.
        //        !"".equalsIgnoreCase(department.getDepartmentName()):
        //        Ensures the departmentName is not an empty string (case-insensitive).
        if(Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())
        ){
            updatingDepartment.setDepartmentName(department.getDepartmentName());
        }

        // Update the departmentAddress field if it's non-null and non-empty.
        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())
        ){
            updatingDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }

        // Update the departmentCode field if it's non-null and non-empty.
        if(Objects.nonNull(department.getDepartmentCode())
                && !"".equalsIgnoreCase(department.getDepartmentCode())
        ){
            updatingDepartment.setDepartmentCode(department.getDepartmentCode());
        }

        // Save the updated department back to the database and return it.
        return departmentRepository.save(updatingDepartment);
    }
}