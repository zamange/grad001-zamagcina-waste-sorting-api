package com.enviro.assessment.grad001.zamagcina_ngeyane.repository;

import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
    // Custom query methods can be added here if needed, e.g.:
    WasteCategory findByName(String name);
}
