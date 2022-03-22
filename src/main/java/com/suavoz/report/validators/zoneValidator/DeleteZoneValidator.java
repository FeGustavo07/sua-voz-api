package com.suavoz.report.validators.zoneValidator;

import com.suavoz.report.domain.AgeGroup;
import com.suavoz.report.domain.Zone;
import com.suavoz.report.gateways.persistence.ZonePersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DeleteZoneValidator {

    private final ZonePersistenceGateway zonePersistenceGateway;

    public List<String> validate(Zone zone) {
        List<String> validationErrors = new ArrayList<>();
        boolean existsZone = zonePersistenceGateway.existsById(zone.getId());

        if (!existsZone) {
            validationErrors.add("Zone doesn't exists");
        }

        if (zone.getId() == null) {
            validationErrors.add("Id is null");
        }

        return validationErrors;
    }
}
