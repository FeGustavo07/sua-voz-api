package com.suavoz.report.usecases.zoneUseCases;

import com.suavoz.report.domain.Zone;
import com.suavoz.report.gateways.persistence.ZonePersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateZone {

    private final ZonePersistenceGateway zonePersistenceGateway;

    public Zone execute(Zone zone) {
        return zonePersistenceGateway.save(zone);
    }

}
