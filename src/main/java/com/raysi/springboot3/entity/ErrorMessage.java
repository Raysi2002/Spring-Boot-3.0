// ErrorMessage.java
package com.raysi.springboot3.entity;

import lombok.AllArgsConstructor; // Generates a constructor with arguments for all fields.
import lombok.Data; // Generates getters, setters, toString, equals, and hashCode methods.
import lombok.NoArgsConstructor; // Generates a no-arguments constructor.
import org.springframework.http.HttpStatus; // Represents HTTP status codes (e.g., 200 OK, 404 NOT FOUND).

// @Data: Lombok annotation to generate boilerplate code like getters and setters.
// @AllArgsConstructor: Creates a constructor with all fields as parameters.
// @NoArgsConstructor: Creates a no-argument constructor.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private HttpStatus status; // Stores the HTTP status (e.g., NOT_FOUND, BAD_REQUEST).
    private String message; // Stores the error message describing the exception.
}