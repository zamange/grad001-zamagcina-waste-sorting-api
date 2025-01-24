package com.enviro.assessment.grad001.zamagcina_ngeyane.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * The WasteCategory class represents a category of waste in the system.
 * Each category has a name and description that provides more information about the type of waste.
 */
@Entity
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    /**
     * Default constructor (required by JPA).
     * This constructor is used by JPA when creating instances of WasteCategory.
     */
    public WasteCategory() {
    }

    /**
     * Parameterized constructor to initialize the WasteCategory with a given name and description.
     *
     * @param name The name of the waste category.
     * @param description The description of the waste category.
     */
    public WasteCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Gets the ID of the WasteCategory.
     *
     * @return The ID of the WasteCategory.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the WasteCategory.
     *
     * @param id The ID to set for the WasteCategory.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the waste category.
     *
     * @return The name of the waste category.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the waste category.
     *
     * @param name The name to set for the waste category.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the waste category.
     *
     * @return The description of the waste category.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the waste category.
     *
     * @param description The description to set for the waste category.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
