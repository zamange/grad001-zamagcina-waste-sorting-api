package com.enviro.assessment.grad001.zamagcina_ngeyane.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * The DisposalGuideline class represents a guideline for disposing waste.
 * It contains information about the disposal guideline and the associated waste category.
 */
@Entity
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guideline;

    @ManyToOne
    private WasteCategory wasteCategory;

    /**
     * Default constructor (required by JPA).
     * This constructor is used by JPA when creating instances of DisposalGuideline.
     */
    public DisposalGuideline() {
    }

    /**
     * Parameterized constructor to initialize the DisposalGuideline with a given guideline and waste category.
     *
     * @param guideline The disposal guideline text.
     * @param wasteCategory The waste category associated with the guideline.
     */
    public DisposalGuideline(String guideline, WasteCategory wasteCategory) {
        this.guideline = guideline;
        this.wasteCategory = wasteCategory;
    }

    /**
     * Gets the ID of the DisposalGuideline.
     *
     * @return The ID of the DisposalGuideline.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the DisposalGuideline.
     *
     * @param id The ID to set for the DisposalGuideline.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the guideline for waste disposal.
     *
     * @return The disposal guideline text.
     */
    public String getGuideline() {
        return guideline;
    }

    /**
     * Sets the disposal guideline text.
     *
     * @param guideline The guideline text to set.
     */
    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }

    /**
     * Gets the waste category associated with the guideline.
     *
     * @return The associated waste category.
     */
    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    /**
     * Sets the waste category associated with the guideline.
     *
     * @param wasteCategory The waste category to set.
     */
    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }
}
