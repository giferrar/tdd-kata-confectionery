package org.example.kata.confectionery.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Cake {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "VARCHAR(1024)")
    private String ingredients;

    @Column
    private Integer calories;

}
