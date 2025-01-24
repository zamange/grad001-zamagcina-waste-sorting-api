package com.enviro.assessment.grad001.zamagcina_ngeyane;

import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.DisposalGuideline;
import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.RecyclingTip;
import com.enviro.assessment.grad001.zamagcina_ngeyane.entity.WasteCategory;
import com.enviro.assessment.grad001.zamagcina_ngeyane.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.zamagcina_ngeyane.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.zamagcina_ngeyane.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.zamagcina_ngeyane.service.DatabaseSeeder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DatabaseSeederTest {

    @Mock
    private WasteCategoryRepository wasteCategoryRepository;

    @Mock
    private DisposalGuidelineRepository disposalGuidelineRepository;

    @Mock
    private RecyclingTipRepository recyclingTipRepository;

    @InjectMocks
    private DatabaseSeeder databaseSeeder;



    @Test
    public void testSeedDatabaseForPlasticCategory() {
        // Call the method to seed the database
        databaseSeeder.seedDatabase();

        // Verify that the plastic waste category was saved
        verify(wasteCategoryRepository).save(Mockito.argThat(wasteCategory -> wasteCategory.getName().equals("Plastic")));

        // Verify that the guideline for plastic was saved
        verify(disposalGuidelineRepository).save(Mockito.argThat(guideline -> guideline.getGuideline().equals("Recycle in blue bin")));

        // Verify that the recycling tip for plastic was saved
        verify(recyclingTipRepository).save(Mockito.argThat(tip -> tip.getTip().equals("Rinse containers before recycling.")));
    }
}
