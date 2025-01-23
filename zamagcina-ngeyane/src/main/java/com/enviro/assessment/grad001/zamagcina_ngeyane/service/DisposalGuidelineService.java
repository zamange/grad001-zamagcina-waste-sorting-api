package com.enviro.assessment.grad001.zamagcina_ngeyane.service;

import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.DisposalGuideline;
import com.enviro.assessment.grad001.zamagcina_ngeyane.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalGuidelineService {

    private final DisposalGuidelineRepository disposalGuidelineRepository;

    @Autowired
    public DisposalGuidelineService(DisposalGuidelineRepository disposalGuidelineRepository) {
        this.disposalGuidelineRepository = disposalGuidelineRepository;
    }

    public List<DisposalGuideline> getAllGuidelines() {
        return disposalGuidelineRepository.findAll();
    }

    public DisposalGuideline getGuidelineById(Long id) {
        return disposalGuidelineRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Disposal guideline not found with id: " + id));
    }

    public List<DisposalGuideline> getGuidelinesByCategory(Long categoryId) {
        return disposalGuidelineRepository.findByWasteCategoryId(categoryId);
    }

    public DisposalGuideline addGuideline(DisposalGuideline guideline) {
        return disposalGuidelineRepository.save(guideline);
    }

    public DisposalGuideline updateGuideline(Long id, DisposalGuideline updatedGuideline) {
        DisposalGuideline existingGuideline = getGuidelineById(id);
        existingGuideline.setGuideline(updatedGuideline.getGuideline());
        existingGuideline.setWasteCategory(updatedGuideline.getWasteCategory());
        return disposalGuidelineRepository.save(existingGuideline);
    }

    public void deleteGuideline(Long id) {
        disposalGuidelineRepository.deleteById(id);
    }
}
