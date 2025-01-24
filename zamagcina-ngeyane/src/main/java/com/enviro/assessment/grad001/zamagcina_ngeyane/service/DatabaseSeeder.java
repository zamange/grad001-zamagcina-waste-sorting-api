package com.enviro.assessment.grad001.zamagcina_ngeyane.service;

import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.DisposalGuideline;
import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.RecyclingTip;
import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.WasteCategory;
import com.enviro.assessment.grad001.zamagcina_ngeyane.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.zamagcina_ngeyane.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.zamagcina_ngeyane.repository.WasteCategoryRepository;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

/**
 * DatabaseSeeder class is responsible for populating the database with initial data
 * upon application startup. This helps ensure that there are predefined values
 * available in the database for waste categories, disposal guidelines, and recycling tips.
 */
@Component
public class DatabaseSeeder {

    private final WasteCategoryRepository wasteCategoryRepository;
    private final DisposalGuidelineRepository disposalGuidelineRepository;
    private final RecyclingTipRepository recyclingTipRepository;

    /**
     * Constructor to initialize the repositories used for saving data.
     *
     * @param wasteCategoryRepository Repository for WasteCategory entities.
     * @param disposalGuidelineRepository Repository for DisposalGuideline entities.
     * @param recyclingTipRepository Repository for RecyclingTip entities.
     */
    public DatabaseSeeder(WasteCategoryRepository wasteCategoryRepository,
                          DisposalGuidelineRepository disposalGuidelineRepository,
                          RecyclingTipRepository recyclingTipRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
        this.disposalGuidelineRepository = disposalGuidelineRepository;
        this.recyclingTipRepository = recyclingTipRepository;
    }

    /**
     * Seed the database with predefined data after the application is fully initialized.
     * This method is annotated with @PostConstruct, which ensures it runs
     * after the bean's properties have been set.
     */
    @PostConstruct
    public void seedDatabase() {
        // Create and save a new waste category for plastic
        WasteCategory plastic = new WasteCategory("Plastic", "Recyclable plastic materials.");
        wasteCategoryRepository.save(plastic);

        // Create and save a new waste category for glass
        WasteCategory glass = new WasteCategory("Glass", "Recyclable glass materials.");
        wasteCategoryRepository.save(glass);

        // Create and save a disposal guideline for plastic
        DisposalGuideline plasticGuideline = new DisposalGuideline("Recycle in blue bin", plastic);
        disposalGuidelineRepository.save(plasticGuideline);

        // Create and save a recycling tip for plastic
        RecyclingTip plasticTip = new RecyclingTip("Rinse containers before recycling.", plastic);
        recyclingTipRepository.save(plasticTip);
    }
}
