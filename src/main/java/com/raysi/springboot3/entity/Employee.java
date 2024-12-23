package com.raysi.springboot3.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employee")
@ToString
public class Employee {
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
    @NotNull(message = "Name can't be blank")
    @Size(min = 2, max = 55, message = "Name must should be in between 2 to 55")
    private String name;
    @Email(message = "Please check you email address again")
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    @Pattern(regexp = "^\\+\\d{1,4}\\s\\d{6,14}$", message = "Phone number must be valid")
    private String phoneNo;
    @Min(value = 18, message = "Age can't be less than 18")
    @Max(value = 100, message = "Age can't be more than 100")
    private Byte age;
    @CreationTimestamp
    private LocalDateTime creationTime;
    @UpdateTimestamp
    private LocalDateTime updatedTime;

}
