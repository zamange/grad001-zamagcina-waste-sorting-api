package com.enviro.assessment.grad001.zamagcina_ngeyane.controller;

import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.RecyclingTip;
import com.enviro.assessment.grad001.zamagcina_ngeyane.service.RecyclingTipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The RecyclingTipController class handles HTTP requests related to recycling tips.
 * It provides RESTful APIs for retrieving, adding, updating, and deleting recycling tips.
 * The endpoints interact with the RecyclingTipService to perform operations on recycling tip data.
 */
@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    private final RecyclingTipService recyclingTipService;

    /**
     * Constructor for RecyclingTipController that initializes the RecyclingTipService.
     *
     * @param recyclingTipService The service that handles business logic for recycling tips.
     */
    @Autowired
    public RecyclingTipController(RecyclingTipService recyclingTipService) {
        this.recyclingTipService = recyclingTipService;
    }

    /**
     * Handles GET requests to retrieve all recycling tips.
     *
     * @return A ResponseEntity containing a list of all recycling tips with a status of 200 OK.
     */
    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllTips() {
        return ResponseEntity.ok(recyclingTipService.getAllTips());
    }

    /**
     * Handles GET requests to retrieve a specific recycling tip by its ID.
     *
     * @param id The ID of the recycling tip to be retrieved.
     * @return A ResponseEntity containing the recycling tip with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getTipById(@PathVariable Long id) {
        return ResponseEntity.ok(recyclingTipService.getTipById(id));
    }

    /**
     * Handles GET requests to retrieve all recycling tips for a specific waste category.
     *
     * @param categoryId The ID of the waste category whose recycling tips are to be retrieved.
     * @return A ResponseEntity containing a list of recycling tips for the specified category.
     */
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<RecyclingTip>> getTipsByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(recyclingTipService.getTipsByCategory(categoryId));
    }

    /**
     * Handles POST requests to add a new recycling tip.
     *
     * @param tip The recycling tip to be added, validated before being passed to the service.
     * @return A ResponseEntity containing the newly created recycling tip and a status of 201 CREATED.
     */
    @PostMapping
    public ResponseEntity<RecyclingTip> addTip(@Valid @RequestBody RecyclingTip tip) {
        return new ResponseEntity<>(recyclingTipService.addTip(tip), HttpStatus.CREATED);
    }

    /**
     * Handles PUT requests to update an existing recycling tip by its ID.
     *
     * @param id The ID of the recycling tip to be updated.
     * @param tip The recycling tip data to update, validated before being passed to the service.
     * @return A ResponseEntity containing the updated recycling tip.
     */
    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip tip) {
        return ResponseEntity.ok(recyclingTipService.updateTip(id, tip));
    }

    /**
     * Handles DELETE requests to remove a recycling tip by its ID.
     *
     * @param id The ID of the recycling tip to be deleted.
     * @return A ResponseEntity with no content and a status of 204 NO CONTENT.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable Long id) {
        recyclingTipService.deleteTip(id);
        return ResponseEntity.noContent().build();
    }
}
