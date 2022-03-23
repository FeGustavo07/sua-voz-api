package com.suavoz.report.usecases.zone;

import com.suavoz.report.domain.Zone;
import com.suavoz.report.gateways.persistence.ZonePersistenceGateway;
import com.suavoz.report.validators.zoneValidator.DeleteZoneValidator;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

@MockitoSettings
class DeleteZoneTest {

    @InjectMocks
    DeleteZone deleteZone;

    @Mock
    DeleteZoneValidator deleteZoneValidator;

    @Mock
    ZonePersistenceGateway zonePersistenceGateway;

    @Test
    void ShouldDeleteWhenValidationSucceed() {
        Zone zone = Zone.builder().build();
        Mockito.when(deleteZoneValidator.validate(zone)).thenReturn(List.of());
        deleteZone.execute(zone);
        Mockito.verify(zonePersistenceGateway).delete(zone);
    }
}