package com.suavoz.report.usecases.zoneUseCases;

import com.suavoz.report.domain.Zone;
import com.suavoz.report.gateways.persistence.ZonePersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteZone {

    private final ZonePersistenceGateway zonePersistenceGateway;

    public void execute(Zone zone) {
        zonePersistenceGateway.delete(zone);
    }

}
