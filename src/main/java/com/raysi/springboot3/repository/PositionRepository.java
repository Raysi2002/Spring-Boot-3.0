// PositionRepository.java
package com.raysi.springboot3.repository;

import com.raysi.springboot3.entity.Position; // Imports the Position entity.
import org.springframework.data.jpa.repository.JpaRepository; // Provides CRUD operations for the entity.
import org.springframework.stereotype.Repository; // Marks this interface as a Spring-managed bean.

@Repository // Indicates that this is a repository layer component.
public interface PositionRepository extends JpaRepository<Position, Long> {
    // JpaRepository provides methods like findAll(), findById(), save(), and delete().
    // The entity is Position, and the primary key type is Long.
}