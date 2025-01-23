package com.enviro.assessment.grad001.zamagcina_ngeyane.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 500)
    private String description;
}
