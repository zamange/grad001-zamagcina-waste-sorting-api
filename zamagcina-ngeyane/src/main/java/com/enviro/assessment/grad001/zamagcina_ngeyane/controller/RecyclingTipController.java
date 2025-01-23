package com.enviro.assessment.grad001.zamagcina_ngeyane.controller;

import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.RecyclingTip;
import com.enviro.assessment.grad001.zamagcina_ngeyane.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    private final RecyclingTipService recyclingTipService;

    @Autowired
    public RecyclingTipController(RecyclingTipService recyclingTipService) {
        this.recyclingTipService = recyclingTipService;
    }

    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllTips() {
        return ResponseEntity.ok(recyclingTipService.getAllTips());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getTipById(@PathVariable Long id) {
        return ResponseEntity.ok(recyclingTipService.getTipById(id));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<RecyclingTip>> getTipsByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(recyclingTipService.getTipsByCategory(categoryId));
    }

    @PostMapping
    public ResponseEntity<RecyclingTip> addTip(@RequestBody RecyclingTip tip) {
        return new ResponseEntity<>(recyclingTipService.addTip(tip), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateTip(@PathVariable Long id, @RequestBody RecyclingTip tip) {
        return ResponseEntity.ok(recyclingTipService.updateTip(id, tip));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable Long id) {
        recyclingTipService.deleteTip(id);
        return ResponseEntity.noContent().build();
    }
}
