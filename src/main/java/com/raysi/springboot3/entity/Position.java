package com.raysi.springboot3.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_seq"
    )
    @SequenceGenerator(
            name = "post_seq",
            sequenceName = "post_sequence",
            allocationSize = 161
    )
    private Long id;
    @NotNull
    @Column(unique = true)
    private String name;
}
