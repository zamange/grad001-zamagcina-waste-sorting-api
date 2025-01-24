package com.enviro.assessment.grad001.zamagcina_ngeyane.service;

import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.WasteCategory;
import com.enviro.assessment.grad001.zamagcina_ngeyane.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {

    private final WasteCategoryRepository wasteCategoryRepository;

    @Autowired
    public WasteCategoryService(WasteCategoryRepository wasteCategoryRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    public List<WasteCategory> getAllCategories() {
        return wasteCategoryRepository.findAll();
    }

    public WasteCategory getCategoryById(Long id) {
        return wasteCategoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Waste category not found with id: " + id));
    }

    public WasteCategory addCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    public WasteCategory updateCategory(Long id, WasteCategory updatedCategory) {
        WasteCategory existingCategory = getCategoryById(id);
        existingCategory.setName(updatedCategory.getName());
        existingCategory.setDescription(updatedCategory.getDescription());
        return wasteCategoryRepository.save(existingCategory);
    }

    public void deleteCategory(Long id) {
        wasteCategoryRepository.deleteById(id);
    }
}
