package com.suavoz.report.usecases.zone;

import com.suavoz.report.domain.Zone;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.ZonePersistenceGateway;
import com.suavoz.report.validators.zoneValidator.DeleteZoneValidator;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteZone {

    private final ZonePersistenceGateway zonePersistenceGateway;
    private final DeleteZoneValidator deleteZoneValidator;

    public void execute(Zone zone) {
        val validationErrors = deleteZoneValidator.validate(zone);

        if (!validationErrors.isEmpty()) {
            throw new ValidationExecption(validationErrors);
        }

        zonePersistenceGateway.delete(zone);
    }

}
