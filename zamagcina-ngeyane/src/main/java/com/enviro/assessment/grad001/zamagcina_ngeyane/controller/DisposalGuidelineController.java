package com.enviro.assessment.grad001.zamagcina_ngeyane.controller;

import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.DisposalGuideline;
import com.enviro.assessment.grad001.zamagcina_ngeyane.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    private final DisposalGuidelineService disposalGuidelineService;

    @Autowired
    public DisposalGuidelineController(DisposalGuidelineService disposalGuidelineService) {
        this.disposalGuidelineService = disposalGuidelineService;
    }

    @GetMapping
    public ResponseEntity<List<DisposalGuideline>> getAllGuidelines() {
        return ResponseEntity.ok(disposalGuidelineService.getAllGuidelines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getGuidelineById(@PathVariable Long id) {
        return ResponseEntity.ok(disposalGuidelineService.getGuidelineById(id));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<DisposalGuideline>> getGuidelinesByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(disposalGuidelineService.getGuidelinesByCategory(categoryId));
    }

    @PostMapping
    public ResponseEntity<DisposalGuideline> addGuideline(@RequestBody DisposalGuideline guideline) {
        return new ResponseEntity<>(disposalGuidelineService.addGuideline(guideline), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateGuideline(@PathVariable Long id, @RequestBody DisposalGuideline guideline) {
        return ResponseEntity.ok(disposalGuidelineService.updateGuideline(id, guideline));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuideline(@PathVariable Long id) {
        disposalGuidelineService.deleteGuideline(id);
        return ResponseEntity.noContent().build();
    }
}
