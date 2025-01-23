package com.enviro.assessment.grad001.zamagcina_ngeyane.repository;

import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {
    // Custom query to find guidelines by waste category
    List<DisposalGuideline> findByWasteCategoryId(Long wasteCategoryId);
}
