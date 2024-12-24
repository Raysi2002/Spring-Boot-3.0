// PositionServiceImplementation.java
package com.raysi.springboot3.service;

import com.raysi.springboot3.entity.Position; // Imports the Position entity.
import com.raysi.springboot3.exceptions.PositionNotFoundException; // Imports the custom exception.
import com.raysi.springboot3.repository.PositionRepository; // Imports the repository for database operations.
import org.springframework.beans.factory.annotation.Autowired; // Injects dependencies.
import org.springframework.stereotype.Service; // Marks this class as a service.

import java.util.List; // For handling lists.
import java.util.Optional; // Represents optional values.

@Service // Marks this class as a service layer component.
public class PositionServiceImplementation implements PositionService {

    private final PositionRepository positionRepository; // Repository for database operations.

    // Constructor-based dependency injection.
    @Autowired
    public PositionServiceImplementation(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<Position> fetchPosts() {
        // Fetches all positions from the database.
        return positionRepository.findAll();
    }

    @Override
    public Position fetchPostById(Long id) throws PositionNotFoundException {
        // Fetches a position by ID, wrapped in an Optional.
        Optional<Position> position = positionRepository.findById(id);
        // If the position is not found, throw the custom exception.
        if (position.isEmpty()) {
            throw new PositionNotFoundException("Bhai position nahi mila matlab db me nahi hai ye position");
        }
        // Return the found position.
        return position.get();
    }

    @Override
    public void savePost(Position position) {
        // Saves a single position to the database.
        positionRepository.save(position);
    }

    @Override
    public void savePosts(List<Position> positions) {
        // Saves multiple positions to the database.
        positionRepository.saveAll(positions);
    }
}