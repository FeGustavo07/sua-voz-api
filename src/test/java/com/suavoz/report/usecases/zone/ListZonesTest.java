package com.suavoz.report.usecases.zone;

import com.suavoz.report.domain.Zone;
import com.suavoz.report.gateways.persistence.ZonePersistenceGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.ArrayList;
import java.util.List;

@MockitoSettings
class ListZonesTest {

    @InjectMocks
    ListZones listZones;

    @Mock
    ZonePersistenceGateway zonePersistenceGateway;

    @Test
    void ShouldReturnAListWhenFindZones() {
        Zone zone = Zone.builder().build();

        List<Zone> zones = new ArrayList<>();

        zones.add(zone);
        zones.add(zone);

        Mockito.when(zonePersistenceGateway.findAll()).thenReturn(List.of(zone, zone));

        List<Zone> zoneList = zonePersistenceGateway.findAll();

        Assertions.assertEquals(zones, zoneList);
        Mockito.verify(zonePersistenceGateway, Mockito.times(1)).findAll();
    }

    @Test
    void ShouldNotReturnAListWhenFindZones() {
        List<Zone> zones = new ArrayList<>();

        List<Zone> zoneList = listZones.execute();

        Assertions.assertEquals(zones, zoneList);
        Mockito.verify(zonePersistenceGateway, Mockito.times(1)).findAll();
    }

}