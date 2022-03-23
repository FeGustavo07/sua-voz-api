package com.suavoz.report.usecases.ageGroup;

import com.suavoz.report.domain.AgeGroup;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.AgeGroupPersistenceGateway;
import com.suavoz.report.validators.ageGroupValidator.DeleteAgeGroupValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

@MockitoSettings
class DeleteAgeGroupTest {

    @InjectMocks
    DeleteAgeGroup deleteAgeGroup;

    @Mock
    DeleteAgeGroupValidator deleteAgeGroupValidator;

    @Mock
    AgeGroupPersistenceGateway ageGroupPersistenceGateway;

    @Test
    void ShouldDeleteWhenValidationSucceed() {
        AgeGroup ageGroup = AgeGroup.builder().build();
        Mockito.when(deleteAgeGroupValidator.validate(ageGroup)).thenReturn(List.of());
        deleteAgeGroup.execute(ageGroup);
        Mockito.verify(ageGroupPersistenceGateway).delete(ageGroup);
    }

    @Test
    void ShouldThrowValidationExceptionWhenFailed() {
        AgeGroup ageGroup = AgeGroup.builder().build();
        Mockito.when(deleteAgeGroupValidator.validate(ageGroup)).thenReturn(List.of("Errors"));
        Assertions.assertThrows(ValidationExecption.class, () -> deleteAgeGroup.execute(ageGroup));
    }

}