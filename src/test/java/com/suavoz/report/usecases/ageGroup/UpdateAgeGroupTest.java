package com.suavoz.report.usecases.ageGroup;

import com.suavoz.report.domain.AgeGroup;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.AgeGroupPersistenceGateway;
import com.suavoz.report.validators.ageGroupValidator.CreateAndUpdateAgeGroupValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

@MockitoSettings
class UpdateAgeGroupTest {

    @InjectMocks
    UpdateAgeGroup updateAgeGroup;

    @Mock
    AgeGroupPersistenceGateway ageGroupPersistenceGateway;

    @Mock
    CreateAndUpdateAgeGroupValidator createAndUpdateAgeGroupValidator;

    @Test
    void ShouldUpdateWhenValidationSucceed() {
        AgeGroup ageGroup = AgeGroup.builder().build();
        Mockito.when(createAndUpdateAgeGroupValidator.validate(ageGroup)).thenReturn(List.of());
        updateAgeGroup.execute(ageGroup);
        Assertions.assertDoesNotThrow(() -> ValidationExecption.class);
        Mockito.verify(ageGroupPersistenceGateway, Mockito.times(1)).save(ageGroup);
    }

    @Test
    void ShouldNotUpdateWhenValidationFailed() {
        AgeGroup ageGroup = AgeGroup.builder().build();
        Mockito.when(createAndUpdateAgeGroupValidator.validate(ageGroup)).thenReturn(List.of("Errors"));
        Assertions.assertThrows(ValidationExecption.class, () -> updateAgeGroup.execute(ageGroup));
    }

}