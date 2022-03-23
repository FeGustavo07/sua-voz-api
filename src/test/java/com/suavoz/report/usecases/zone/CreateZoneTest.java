package com.suavoz.report.usecases.zone;

import com.suavoz.report.domain.Zone;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.ZonePersistenceGateway;
import com.suavoz.report.validators.zoneValidator.CreateAndUpdateZoneValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

@MockitoSettings
class CreateZoneTest {

    @InjectMocks
    CreateZone createZone;

    @Mock
    CreateAndUpdateZoneValidator createAndUpdateZoneValidator;

    @Mock
    ZonePersistenceGateway zonePersistenceGateway;

    @Test
    void ShouldSaveWhenValidationSucceed() {
        Zone zone = Zone.builder().build();
        Mockito.when(createAndUpdateZoneValidator.validate(zone)).thenReturn(List.of());
        createZone.execute(zone);
        Mockito.verify(zonePersistenceGateway).save(zone);
    }

    @Test
    void ShouldReturnValidationExceptionWhenValidationFailed() {
        Zone zone = Zone.builder().build();
        Mockito.when(createAndUpdateZoneValidator.validate(zone)).thenReturn(List.of("Errors"));
        Assertions.assertThrows(ValidationExecption.class, () -> createZone.execute(zone));
    }

}