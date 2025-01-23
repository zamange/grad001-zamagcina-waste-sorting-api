package com.enviro.assessment.grad001.zamagcina_ngeyane.repository;

import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {
    // Custom query to find recycling tips by waste category
    List<RecyclingTip> findByWasteCategoryId(Long wasteCategoryId);
}
