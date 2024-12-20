package com.raysi.springboot3.controller;

// Importing required Spring annotations for RESTful web services
import org.springframework.web.bind.annotation.RequestMapping; // Used to map web requests to handler methods
import org.springframework.web.bind.annotation.RestController; // Indicates that this class is a REST controller

/**
 * This is a REST controller class for handling HTTP requests in the application.
 */
@RestController // Marks this class as a RESTful controller where every method returns a response body (no need for @ResponseBody).
public class HomeController {

    /**
     * Handles the root ("/") URL of the application.
     * When a user accesses the root URL, this method returns an HTML response as a string.
     *
     * @return An HTML string that renders a welcome message when accessed via a browser.
     */
    @RequestMapping("/") // Maps the root URL ("/") to this method for handling HTTP GET requests.
    public String home() {
        // Returning an HTML response as a string using a multi-line text block.
        return """
                <head>
                    <title>Document</title> <!-- Sets the title of the web page -->
                </head>
                <body>
                    <!-- Displays a welcome message centered on the page -->
                    <h1 style="text-align: center">Welcome to Spring Boot 3.0</h1>
                </body>
                </html> <!-- Closing the HTML structure -->
                """;
    }
}