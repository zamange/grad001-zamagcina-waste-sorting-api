package com.enviro.assessment.grad001.zamagcina_ngeyane.service;

import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.RecyclingTip;
import com.enviro.assessment.grad001.zamagcina_ngeyane.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {

    private final RecyclingTipRepository recyclingTipRepository;

    @Autowired
    public RecyclingTipService(RecyclingTipRepository recyclingTipRepository) {
        this.recyclingTipRepository = recyclingTipRepository;
    }

    public List<RecyclingTip> getAllTips() {
        return recyclingTipRepository.findAll();
    }

    public RecyclingTip getTipById(Long id) {
        return recyclingTipRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Recycling tip not found with id: " + id));
    }

    public List<RecyclingTip> getTipsByCategory(Long categoryId) {
        return recyclingTipRepository.findByWasteCategoryId(categoryId);
    }

    public RecyclingTip addTip(RecyclingTip tip) {
        return recyclingTipRepository.save(tip);
    }

    public RecyclingTip updateTip(Long id, RecyclingTip updatedTip) {
        RecyclingTip existingTip = getTipById(id);
        existingTip.setTip(updatedTip.getTip());
        existingTip.setWasteCategory(updatedTip.getWasteCategory());
        return recyclingTipRepository.save(existingTip);
    }

    public void deleteTip(Long id) {
        recyclingTipRepository.deleteById(id);
    }
}
