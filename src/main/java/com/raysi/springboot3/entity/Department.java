package com.raysi.springboot3.entity;

import jakarta.persistence.*;  // Importing JPA annotations for ORM (Object-Relational Mapping)
import lombok.*;

@Entity  // Marks this class as a JPA entity, meaning it will be mapped to a table in the database
@Data  // Generates getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor  // Generates a constructor with all fields as arguments
@NoArgsConstructor  // Generates a no-argument constructor
@Builder  // Implements the builder pattern for this class, allowing for easy object creation
@Table(name = "department")  // Specifies the table name in the database that this entity will map to

public class Department {

    @Id  // Marks this field as the primary key of the entity
    @GeneratedValue(  // Specifies the strategy for generating the primary key value
            strategy = GenerationType.SEQUENCE,  // Using a sequence-based strategy for ID generation
            generator = "department_seq"  // Specifies the name of the sequence generator
    )
    @SequenceGenerator(  // Configures the sequence generator
            name = "department_seq",  // Name of the sequence generator
            sequenceName = "department_sequence",  // Name of the database sequence
            allocationSize = 116  // Specifies the allocation size for the sequence (how many values are pre-allocated at a time)
    )
    private Long departmentId;  // Primary key field for the department entity

    @Column(nullable = false)
    private String departmentName;  // Name of the department, cannot be null

    @Column(nullable = false)
    private String departmentAddress;  // Address of the department, cannot be null

    @Column(nullable = false)
    private String departmentCode;  // Code associated with the department, cannot be null

    @Override
    public String toString(){
        // Overridden toString method to provide a custom string representation of the Department entity.
        // Returns a string containing department details in a readable format.
        return "Department Name: " + departmentName +
                " Department Address: " + departmentAddress +
                " Department Code: " + departmentCode;
    }
}