package com.enviro.assessment.grad001.zamagcina_ngeyane.service;

import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.DisposalGuideline;
import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.RecyclingTip;
import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.WasteCategory;
import com.enviro.assessment.grad001.zamagcina_ngeyane.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.zamagcina_ngeyane.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.zamagcina_ngeyane.repository.WasteCategoryRepository;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class DatabaseSeeder {

    private final WasteCategoryRepository wasteCategoryRepository;
    private final DisposalGuidelineRepository disposalGuidelineRepository;
    private final RecyclingTipRepository recyclingTipRepository;

    public DatabaseSeeder(WasteCategoryRepository wasteCategoryRepository,
                          DisposalGuidelineRepository disposalGuidelineRepository,
                          RecyclingTipRepository recyclingTipRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
        this.disposalGuidelineRepository = disposalGuidelineRepository;
        this.recyclingTipRepository = recyclingTipRepository;
    }

    @PostConstruct
    public void seedDatabase() {
        WasteCategory plastic = new WasteCategory("Plastic", "Recyclable plastic materials.");
        wasteCategoryRepository.save(plastic);

        WasteCategory glass = new WasteCategory("Glass", "Recyclable glass materials.");
        wasteCategoryRepository.save(glass);

        DisposalGuideline plasticGuideline = new DisposalGuideline("Recycle in blue bin", plastic);
        disposalGuidelineRepository.save(plasticGuideline);

        RecyclingTip plasticTip = new RecyclingTip("Rinse containers before recycling.", plastic);
        recyclingTipRepository.save(plasticTip);
    }
}
