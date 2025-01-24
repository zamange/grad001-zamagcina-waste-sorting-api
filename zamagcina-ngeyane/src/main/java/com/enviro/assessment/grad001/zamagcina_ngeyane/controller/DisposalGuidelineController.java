package com.enviro.assessment.grad001.zamagcina_ngeyane.controller;

import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.DisposalGuideline;
import com.enviro.assessment.grad001.zamagcina_ngeyane.service.DisposalGuidelineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The DisposalGuidelineController class handles REST API requests related to disposal guidelines.
 * It exposes endpoints for retrieving, adding, updating, and deleting disposal guidelines.
 */
@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    private final DisposalGuidelineService disposalGuidelineService;

    /**
     * Constructor for DisposalGuidelineController.
     *
     * @param disposalGuidelineService The service responsible for handling the business logic related to disposal guidelines.
     */
    @Autowired
    public DisposalGuidelineController(DisposalGuidelineService disposalGuidelineService) {
        this.disposalGuidelineService = disposalGuidelineService;
    }

    /**
     * Endpoint to retrieve all disposal guidelines.
     *
     * @return A ResponseEntity containing a list of all disposal guidelines.
     */
    @GetMapping
    public ResponseEntity<List<DisposalGuideline>> getAllGuidelines() {
        // Fetch all disposal guidelines from the service
        return ResponseEntity.ok(disposalGuidelineService.getAllGuidelines());
    }

    /**
     * Endpoint to retrieve a specific disposal guideline by its ID.
     *
     * @param id The ID of the disposal guideline to retrieve.
     * @return A ResponseEntity containing the requested disposal guideline.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getGuidelineById(@PathVariable Long id) {
        // Fetch the disposal guideline by ID from the service
        return ResponseEntity.ok(disposalGuidelineService.getGuidelineById(id));
    }

    /**
     * Endpoint to retrieve disposal guidelines by category ID.
     *
     * @param categoryId The ID of the waste category to filter the guidelines by.
     * @return A ResponseEntity containing a list of disposal guidelines associated with the specified category.
     */
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<DisposalGuideline>> getGuidelinesByCategory(@PathVariable Long categoryId) {
        // Fetch disposal guidelines by category from the service
        return ResponseEntity.ok(disposalGuidelineService.getGuidelinesByCategory(categoryId));
    }

    /**
     * Endpoint to add a new disposal guideline.
     *
     * @param guideline The disposal guideline to add, passed in the request body.
     * @return A ResponseEntity containing the newly created disposal guideline and an HTTP status of CREATED.
     */
    @PostMapping
    public ResponseEntity<DisposalGuideline> addGuideline(@Valid @RequestBody DisposalGuideline guideline) {
        // Add the new disposal guideline using the service
        return new ResponseEntity<>(disposalGuidelineService.addGuideline(guideline), HttpStatus.CREATED);
    }

    /**
     * Endpoint to update an existing disposal guideline by its ID.
     *
     * @param id The ID of the disposal guideline to update.
     * @param guideline The updated disposal guideline, passed in the request body.
     * @return A ResponseEntity containing the updated disposal guideline.
     */
    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuideline guideline) {
        // Update the disposal guideline using the service
        return ResponseEntity.ok(disposalGuidelineService.updateGuideline(id, guideline));
    }

    /**
     * Endpoint to delete a disposal guideline by its ID.
     *
     * @param id The ID of the disposal guideline to delete.
     * @return A ResponseEntity indicating that the deletion was successful, with no content in the response body.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuideline(@PathVariable Long id) {
        // Delete the disposal guideline using the service
        disposalGuidelineService.deleteGuideline(id);
        return ResponseEntity.noContent().build(); // Return a 204 No Content response
    }
}
