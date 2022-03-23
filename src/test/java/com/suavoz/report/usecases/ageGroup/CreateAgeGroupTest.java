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
class CreateAgeGroupTest {

    @InjectMocks
    CreateAgeGroup createAgeGroup;

    @Mock
    CreateAndUpdateAgeGroupValidator createAndUpdateAgeGroupValidator;

    @Mock
    AgeGroupPersistenceGateway ageGroupPersistenceGateway;

    @Test
    void ShouldSaveWhenValidationSucceed() {
        AgeGroup ageGroup = AgeGroup.builder().build();
        Mockito.when(createAndUpdateAgeGroupValidator.validate(ageGroup)).thenReturn(List.of());
        createAgeGroup.execute(ageGroup);
        Mockito.verify(ageGroupPersistenceGateway).save(ageGroup);
    }

    @Test
    void ShouldDoNotSaveWhenValidationFailed() {
        AgeGroup ageGroup = AgeGroup.builder().build();
        Mockito.when(createAndUpdateAgeGroupValidator.validate(ageGroup)).thenReturn(List.of("Errors"));
        Assertions.assertThrows(ValidationExecption.class, ()-> createAgeGroup.execute(ageGroup));
    }

}