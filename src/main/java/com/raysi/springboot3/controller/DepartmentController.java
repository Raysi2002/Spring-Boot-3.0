package com.raysi.springboot3.controller;

import com.raysi.springboot3.entity.Department;
import com.raysi.springboot3.service.DepartmentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

// @RestController is a specialized annotation in Spring that combines @Controller and @ResponseBody.
// It indicates that this class is a controller where every method returns a response body (typically JSON).
@RestController
public class DepartmentController {

    // Declares a final field for DepartmentService to ensure immutability and proper dependency injection.
    private final DepartmentService departmentService;

    // Constructor-based dependency injection for DepartmentService.
    // This approach is preferred in modern Spring applications because it enforces immutability and better testability.
    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // @GetMapping is used to map HTTP GET requests to this method.
    // This endpoint fetches a list of all departments.
    // URL: /api/dept
    @GetMapping("/api/dept")
    public List<Department> fetchDepartments() {
        // Calls the service layer to retrieve all departments from the database.
        return departmentService.fetchDepartments();
    }

    // @PostMapping is used to map HTTP POST requests to this method.
    // This endpoint is used to save a new department.
    // URL: /api/dept
    @PostMapping("/api/dept")
    public String saveDepartment(@RequestBody Department department) {
        // The @RequestBody annotation binds the incoming JSON payload to the Department object.
        // Calls the service layer to save the provided department into the database.
        departmentService.saveDepartment(department);

        // Returns the string representation of the saved department as a response.
        return department.toString();
    }

    // @PostMapping to handle saving multiple departments in a batch.
    // URL: /api/depts
    @PostMapping("/api/depts")
    public String saveDepartments(@RequestBody List<Department> departments) {
        // The @RequestBody annotation binds the incoming JSON request payload to the 'departments' parameter.
        // The JSON payload should be an array of Department objects, which Spring will automatically convert to a List<Department>.

        // Calls the saveDepartments method in the DepartmentService layer to persist the list of Department entities.
        departmentService.saveDepartments(departments);

        // Returns the list of departments as a String.
        // This provides a simple confirmation response, showing the saved departments' details.
        return departments.toString();
    }

    // @GetMapping to fetch a department by its ID.
    // URL: /api/dept/{id}
    @GetMapping("/api/dept/{id}")
    public Department fetchDepartmentById(@PathVariable Long id){
        // Calls the service layer to retrieve a department by its ID.
        return departmentService.fetchDepartmentById(id);
    }

    // @DeleteMapping is used to map HTTP DELETE requests to this method.
    // URL: /api/dept/{id}
    public String deleteDepartmentById(@PathVariable Long id){
        // Calls the service layer to delete a department by its ID.
        departmentService.deleteDepartmentById(id);
        return "Department with id: " + id + " has been deleted successfully";
    }

    // Another @DeleteMapping to delete a department by its ID using JPA method.
    // URL: /api/department/{id}
    @DeleteMapping("/api/department/{id}")
    public String deleteDepartmentByIdJpaMethod(@PathVariable Long id){
        // Calls the service layer to delete a department using JPA's built-in deleteById method.
        departmentService.deleteDepartmentByIdJpaMethod(id);
        return "Department with id: " + id + " has been deleted successfully";
    }

    // @PutMapping is used to update a department by its ID.
    // URL: /api/dept/{id}
    @PutMapping("/api/dept/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department){
        // Calls the service layer to update a department by its ID.
        return departmentService.updateDepartment(id, department);
    }

    // Method 1: Fetch a list of departments by department name
    @GetMapping("api/depts/name/{deptName}")
    public List<Department> fetchDepartmentsByDeptName(@PathVariable String deptName) {
        // This method is used to retrieve multiple departments that match the given department name.
        // It uses the departmentService to call the fetchDepartmentByDeptName() method.
        // Ideal for scenarios where the department name is not unique,
        // and multiple departments with the same name might exist.
        // Returns: A list of Department objects.
        // Example API call: GET /api/depts/name/Finance
        return departmentService.fetchDepartmentByDeptName(deptName);
    }

    // Method 2: Fetch a single department by department name using a native query
    @GetMapping("api/dept/name/{deptName}")
    public Department fetchDepartmentsByDeptNameNative(@PathVariable String deptName) {
        // This method is used to retrieve a single department by its name.
        // Assumes that the department name is unique and will return exactly one result.
        // It uses a native query implementation through departmentService's fetchDepartmentByDeptNameNative() method.
        // Ideal for performance optimization when working directly with SQL or when additional flexibility is required.
        // Returns: A single Department object.
        // Example API call: GET /api/dept/name/Finance
        return departmentService.fetchDepartmentByDeptNameNative(deptName);
    }

}

