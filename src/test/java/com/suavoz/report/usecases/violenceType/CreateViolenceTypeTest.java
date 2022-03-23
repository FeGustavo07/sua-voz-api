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
class CreateViolenceTypeTest {

    @InjectMocks
    CreateViolenceType createViolenceType;

    @Mock
    CreateAndUpdateVtValidator createAndUpdateVtValidator;

    @Mock
    ViolenceTypePersistenceGateway violenceTypePersistenceGateway;

    @Test
    void ShouldCreateWhenValidationSucced() {
        ViolenceType violenceType = ViolenceType.builder().build();
        Mockito.when(createAndUpdateVtValidator.validate(violenceType)).thenReturn(List.of());
        createViolenceType.execute(violenceType);
        Mockito.verify(violenceTypePersistenceGateway).save(violenceType);
    }

    @Test
    void ShouldNotCreateWhenValidationFailed() {
        ViolenceType violenceType = ViolenceType.builder().build();
        Mockito.when(createAndUpdateVtValidator.validate(violenceType)).thenReturn(List.of("Errors"));
        Assertions.assertThrows(ValidationExecption.class, () -> createViolenceType.execute(violenceType));
    }

}