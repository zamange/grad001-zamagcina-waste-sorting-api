package com.enviro.assessment.grad001.zamagcina_ngeyane.controller;

import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.WasteCategory;
import com.enviro.assessment.grad001.zamagcina_ngeyane.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    private final WasteCategoryService wasteCategoryService;

    @Autowired
    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllCategories() {
        return ResponseEntity.ok(wasteCategoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(wasteCategoryService.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<WasteCategory> addCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        return new ResponseEntity<>(wasteCategoryService.addCategory(wasteCategory), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory wasteCategory) {
        return ResponseEntity.ok(wasteCategoryService.updateCategory(id, wasteCategory));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
