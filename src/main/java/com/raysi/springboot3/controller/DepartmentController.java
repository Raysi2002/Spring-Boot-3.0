package com.raysi.springboot3.controller;

import com.raysi.springboot3.entity.Department;
import com.raysi.springboot3.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping("/api/depts")
    public String saveDepartments(@RequestBody List<Department> departments) {
        // The @PostMapping annotation maps HTTP POST requests to this method.
        // This endpoint is designed to handle batch saving of multiple Department entities.

        // @RequestBody annotation binds the incoming JSON request payload to the 'departments' parameter.
        // The JSON payload should be an array of Department objects, which Spring will automatically convert to a List<Department>.

        // Calls the saveDepartments method in the DepartmentService layer to persist the list of Department entities.
        departmentService.saveDepartments(departments);

        // Returns the list of departments as a String.
        // This provides a simple confirmation response, showing the saved departments' details.
        return departments.toString();
    }
}