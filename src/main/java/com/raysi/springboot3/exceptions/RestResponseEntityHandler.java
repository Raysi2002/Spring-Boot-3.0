// RestResponseEntityHandler.java
package com.raysi.springboot3.exceptions;

import com.raysi.springboot3.entity.ErrorMessage; // Custom entity to encapsulate error details in the response.
import org.springframework.http.HttpStatus; // Represents HTTP status codes such as 404 (NOT_FOUND), 500 (INTERNAL_SERVER_ERROR), etc.
import org.springframework.http.ResponseEntity; // Represents the full HTTP response, including status, headers, and body.
import org.springframework.web.bind.annotation.ControllerAdvice; // Allows centralized exception handling across multiple controllers.
import org.springframework.web.bind.annotation.ExceptionHandler; // Maps a specific exception type to a handler method.
import org.springframework.web.bind.annotation.ResponseStatus; // Sets a default HTTP status for exceptions (if needed).
import org.springframework.web.context.request.WebRequest; // Provides contextual information about the current web request (e.g., URL, headers).
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler; // Base class for handling exceptions and building HTTP responses.

// Marks this class as a centralized exception handler for all controllers in the application.
@ControllerAdvice
// Used to define default HTTP status codes for exceptions (not actively used in this implementation).
@ResponseStatus
public class RestResponseEntityHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles exceptions of type PositionNotFoundException.
     * This method generates a structured error response with an appropriate HTTP status and error message.
     *
     * @param positionNotFoundException The exception that was thrown, containing error details.
     * @param webRequest The web request object, which provides additional context about the HTTP request (e.g., headers, URL).
     * @return A ResponseEntity containing the error details and HTTP status code.
     */
    @ExceptionHandler(PositionNotFoundException.class) // Maps this method to handle PositionNotFoundException.
    public ResponseEntity<ErrorMessage> positionNotFoundException(PositionNotFoundException positionNotFoundException,
                                                                  WebRequest webRequest) {
        // Create an ErrorMessage object to hold structured error information.
        // ErrorMessage has two fields:
        // 1. status: The HTTP status code (e.g., 404 for NOT_FOUND).
        // 2. message: A human-readable description of the error (extracted from the exception).
        ErrorMessage errorMessage = new ErrorMessage(
                HttpStatus.NOT_FOUND, // Sets the HTTP status to 404, indicating that the requested resource was not found.
                positionNotFoundException.getMessage() // Extracts the custom error message from the exception.
        );

        // Return a ResponseEntity object containing:
        // - The HTTP status (404 NOT_FOUND).
        // - The ErrorMessage object as the response body.
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND) // Sets the status of the HTTP response to 404.
                .body(errorMessage); // Includes the ErrorMessage object as the response body.
    }
}