package com.suavoz.report.usecases.violenceType;

import com.suavoz.report.domain.ViolenceType;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.ViolenceTypePersistenceGateway;
import com.suavoz.report.validators.violenceTypeValidator.CreateAndUpdateVtValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

@MockitoSettings
class UpdateViolenceTypeTest {

    @InjectMocks
    UpdateViolenceType updateViolenceType;

    @Mock
    CreateAndUpdateVtValidator createAndUpdateVtValidator;

    @Mock
    ViolenceTypePersistenceGateway violenceTypePersistenceGateway;

    @Test
    void ShouldUpdateWhenValidationSucceed() {
        ViolenceType violenceType = ViolenceType.builder().build();
        Mockito.when(createAndUpdateVtValidator.validate(violenceType)).thenReturn(List.of());
        updateViolenceType.execute(violenceType);
        Assertions.assertDoesNotThrow(() -> ValidationExecption.class);
        Mockito.verify(violenceTypePersistenceGateway, Mockito.times(1)).save(violenceType);
    }

    @Test
    void ShouldNotUpdateWhenValidationFailed() {
        ViolenceType violenceType = ViolenceType.builder().build();
        Mockito.when(createAndUpdateVtValidator.validate(violenceType)).thenReturn(List.of("Errors"));
        Assertions.assertThrows(ValidationExecption.class, () -> updateViolenceType.execute(violenceType));
    }

}