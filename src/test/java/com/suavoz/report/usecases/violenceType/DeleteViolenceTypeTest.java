package com.suavoz.report.usecases.violenceType;

import com.suavoz.report.domain.ViolenceType;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.ViolenceTypePersistenceGateway;
import com.suavoz.report.validators.violenceTypeValidator.DeleteVtValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

@MockitoSettings
class DeleteViolenceTypeTest {

    @InjectMocks
    DeleteViolenceType deleteViolenceType;

    @Mock
    DeleteVtValidator deleteVtValidator;

    @Mock
    ViolenceTypePersistenceGateway violenceTypePersistenceGateway;

    @Test
    void ShouldDeleteWhenValidationSucceed() {
        ViolenceType violenceType = ViolenceType.builder().build();
        Mockito.when(deleteVtValidator.validate(violenceType)).thenReturn(List.of());
        deleteViolenceType.execute(violenceType);
        Mockito.verify(violenceTypePersistenceGateway).delete(violenceType);
    }

    @Test
    void ShouldNotDeleteWhenValidationFailed() {
        ViolenceType violenceType = ViolenceType.builder().build();
        Mockito.when(deleteVtValidator.validate(violenceType)).thenReturn(List.of("Errors"));
        Assertions.assertThrows(ValidationExecption.class, () -> deleteViolenceType.execute(violenceType));
    }

}