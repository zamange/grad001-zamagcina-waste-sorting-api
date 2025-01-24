package com.enviro.assessment.grad001.zamagcina_ngeyane.controller;

import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.WasteCategory;
import com.enviro.assessment.grad001.zamagcina_ngeyane.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The WasteCategoryController class handles HTTP requests related to waste categories.
 * It provides RESTful APIs for retrieving, adding, updating, and deleting waste category data.
 * The endpoints interact with the WasteCategoryService to perform operations on waste category data.
 */
@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    private final WasteCategoryService wasteCategoryService;

    /**
     * Constructor for WasteCategoryController that initializes the WasteCategoryService.
     *
     * @param wasteCategoryService The service that handles business logic for waste categories.
     */
    @Autowired
    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }

    /**
     * Handles GET requests to retrieve all waste categories.
     *
     * @return A ResponseEntity containing a list of all waste categories with a status of 200 OK.
     */
    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllCategories() {
        return ResponseEntity.ok(wasteCategoryService.getAllCategories());
    }

    /**
     * Handles GET requests to retrieve a specific waste category by its ID.
     *
     * @param id The ID of the waste category to be retrieved.
     * @return A ResponseEntity containing the waste category with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(wasteCategoryService.getCategoryById(id));
    }

    /**
     * Handles POST requests to add a new waste category.
     *
     * @param wasteCategory The waste category to be added, validated before being passed to the service.
     * @return A ResponseEntity containing the newly created waste category and a status of 201 CREATED.
     */
    @PostMapping
    public ResponseEntity<WasteCategory> addCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        return new ResponseEntity<>(wasteCategoryService.addCategory(wasteCategory), HttpStatus.CREATED);
    }

    /**
     * Handles PUT requests to update an existing waste category by its ID.
     *
     * @param id The ID of the waste category to be updated.
     * @param wasteCategory The waste category data to update, validated before being passed to the service.
     * @return A ResponseEntity containing the updated waste category.
     */
    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory wasteCategory) {
        return ResponseEntity.ok(wasteCategoryService.updateCategory(id, wasteCategory));
    }

    /**
     * Handles DELETE requests to remove a waste category by its ID.
     *
     * @param id The ID of the waste category to be deleted.
     * @return A ResponseEntity with no content and a status of 204 NO CONTENT.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
