package com.enviro.assessment.grad001.zamagcina_ngeyane.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guideline;

    @ManyToOne
    private WasteCategory wasteCategory;

    // Default constructor (required by JPA)
    public DisposalGuideline() {
    }

    // Parameterized constructor
    public DisposalGuideline(String guideline, WasteCategory wasteCategory) {
        this.guideline = guideline;
        this.wasteCategory = wasteCategory;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuideline() {
        return guideline;
    }

    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }

    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }
}
