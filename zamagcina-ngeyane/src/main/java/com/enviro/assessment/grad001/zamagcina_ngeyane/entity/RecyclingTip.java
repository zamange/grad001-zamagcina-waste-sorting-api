package com.enviro.assessment.grad001.zamagcina_ngeyane.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RecyclingTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "waste_category_id", nullable = false)
    private WasteCategory wasteCategory;

    @Column(nullable = false, length = 1000)
    private String tip;
}
