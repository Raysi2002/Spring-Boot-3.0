package com.raysi.springboot3.entity;

// Entity Class: Employee
// Includes field validations and logging support.

import jakarta.persistence.*; // ORM annotations for mapping.
import jakarta.validation.constraints.*; // Validation constraints.
import lombok.*; // Lombok for boilerplate code reduction.
import org.hibernate.annotations.CreationTimestamp; // Auto-generation of creation timestamp.
import org.hibernate.annotations.UpdateTimestamp; // Auto-update of modification timestamp.
import org.slf4j.Logger; // Logger interface.
import org.slf4j.LoggerFactory; // Factory for logger instances.

import java.time.LocalDateTime;

@Entity // Marks this class as a JPA entity.
@Data // Lombok: Generates getters, setters, equals, hashCode, and toString methods.
@AllArgsConstructor // Lombok: Constructor with all fields.
@NoArgsConstructor // Lombok: No-argument constructor.
@Builder // Lombok: Simplifies object creation with the builder pattern.
@Table(name = "employee") // Table name in the database.
@ToString // Lombok: Generates a toString method for debugging.
public class Employee {

    // Adding Logger
    private static final Logger logger = LoggerFactory.getLogger(Employee.class);

    // Unique identifier for the employee, generated using a sequence strategy.
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "emp_seq"
    )
    @SequenceGenerator(
            name = "emp_seq",
            sequenceName = "employee_sequence",
            allocationSize = 116
    )
    private Long id;

    // Validations for `name`:
    // - @NotNull ensures `name` is not null.
    // - @Size restricts the length to 2-55 characters.
    @NotNull(message = "Name can't be blank")
    @Size(min = 2, max = 55, message = "Name must be between 2 to 55 characters")
    private String name;

    // Validations for `email`:
    // - @Email ensures valid email format.
    // - @Column(unique = true) enforces uniqueness.
    @Email(message = "Please check your email address again")
    @Column(unique = true)
    private String email;

    // Validations for `phoneNo`:
    // - @Pattern ensures phone numbers match a specific format.
    //-regexp ensures the patter of specific format
    // - @Column(unique = true) enforces uniqueness.
    @Column(unique = true)
    @Pattern(regexp = "^\\+\\d{1,4}\\s\\d{6,14}$", message = "Phone number must be valid")
    private String phoneNo;

    // Validations for `age`:
    // - @Min ensures the minimum value is 18.
    // - @Max ensures the maximum value is 100.
    @Min(value = 18, message = "Age can't be less than 18")
    @Max(value = 100, message = "Age can't be more than 100")
    private Byte age;

    // Auto-generation of timestamps:
    // - @CreationTimestamp: Sets the creation time.
    // - @UpdateTimestamp: Updates the timestamp on modifications.
    @CreationTimestamp
    private LocalDateTime creationTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

    // Method demonstrating logging
    public void logDetails() {
        logger.info("Employee Details: {}", this);
        logger.debug("Employee debug info: ID = {}, Name = {}", id, name);
    }
}