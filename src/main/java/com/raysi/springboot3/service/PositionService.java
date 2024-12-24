// PositionService.java
package com.raysi.springboot3.service;

import com.raysi.springboot3.entity.Position; // Imports the Position entity.
import com.raysi.springboot3.exceptions.PositionNotFoundException; // Imports the custom exception.
import org.springframework.stereotype.Service; // Marks this interface as a service layer component.

import java.util.List; // For handling lists.

@Service // Marks this interface as a service in the application context.
public interface PositionService {
    // Fetch all positions.
    List<Position> fetchPosts();

    // Fetch a specific position by its ID.
    // Throws PositionNotFoundException if the position is not found.
    Position fetchPostById(Long id) throws PositionNotFoundException;

    // Save a single position to the database.
    void savePost(Position position);

    // Save multiple positions to the database.
    void savePosts(List<Position> positions);
}