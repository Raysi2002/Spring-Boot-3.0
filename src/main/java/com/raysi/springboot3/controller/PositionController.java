// PositionController.java
package com.raysi.springboot3.controller;

import com.raysi.springboot3.entity.Position; // Imports the Position entity.
import com.raysi.springboot3.exceptions.PositionNotFoundException; // Imports the custom exception.
import com.raysi.springboot3.service.PositionService; // Imports the service layer.
import org.springframework.beans.factory.annotation.Autowired; // Injects dependencies.
import org.springframework.web.bind.annotation.*; // For REST APIs.

import java.util.List; // For handling lists.

@RestController // Marks this class as a REST controller.
public class PositionController {

    private final PositionService positionService; // Service layer dependency.

    // Constructor-based dependency injection.
    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/api/post")
    public List<Position> fetchPosts() {
        // Fetches all positions via the service layer.
        return positionService.fetchPosts();
    }

    @GetMapping("/api/post/{id}")
    public Position fetchPostById(@PathVariable Long id) throws PositionNotFoundException {
        // Fetches a position by ID. Throws PositionNotFoundException if not found.
        return positionService.fetchPostById(id);
    }

    @PostMapping("/api/posts")
    public String savePosts(@RequestBody List<Position> positions) {
        // Saves multiple positions to the database.
        positionService.savePosts(positions);
        return positions.toString();
    }

    @PostMapping("/api/post")
    public String savePost(@RequestBody Position position) {
        // Saves a single position to the database.
        positionService.savePost(position);
        return position.toString();
    }
}