package com.enviro.assessment.grad001.zamagcina_ngeyane.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * The RecyclingTip class represents a tip or suggestion for recycling waste.
 * It contains information about the recycling tip and the associated waste category.
 */
@Entity
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tip;

    @ManyToOne
    private WasteCategory wasteCategory;

    /**
     * Default constructor (required by JPA).
     * This constructor is used by JPA when creating instances of RecyclingTip.
     */
    public RecyclingTip() {
    }

    /**
     * Parameterized constructor to initialize the RecyclingTip with a given tip and waste category.
     *
     * @param tip The recycling tip text.
     * @param wasteCategory The waste category associated with the recycling tip.
     */
    public RecyclingTip(String tip, WasteCategory wasteCategory) {
        this.tip = tip;
        this.wasteCategory = wasteCategory;
    }

    /**
     * Gets the ID of the RecyclingTip.
     *
     * @return The ID of the RecyclingTip.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the RecyclingTip.
     *
     * @param id The ID to set for the RecyclingTip.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the recycling tip text.
     *
     * @return The recycling tip text.
     */
    public String getTip() {
        return tip;
    }

    /**
     * Sets the recycling tip text.
     *
     * @param tip The tip text to set.
     */
    public void setTip(String tip) {
        this.tip = tip;
    }

    /**
     * Gets the waste category associated with the recycling tip.
     *
     * @return The associated waste category.
     */
    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    /**
     * Sets the waste category associated with the recycling tip.
     *
     * @param wasteCategory The waste category to set.
     */
    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }
}
