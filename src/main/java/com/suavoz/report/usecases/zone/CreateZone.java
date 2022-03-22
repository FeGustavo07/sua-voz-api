package com.suavoz.report.usecases.zone;

import com.suavoz.report.domain.Zone;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.ZonePersistenceGateway;
import com.suavoz.report.validators.zoneValidator.CreateAndUpdateZoneValidator;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateZone {

    private final ZonePersistenceGateway zonePersistenceGateway;
    private final CreateAndUpdateZoneValidator createAndUpdateZoneValidator;

    public Zone execute(Zone zone) {
        val validationErrors = createAndUpdateZoneValidator.validate(zone);

        if (!validationErrors.isEmpty()) {
            throw new ValidationExecption(validationErrors);
        }

        return zonePersistenceGateway.save(zone);
    }

}
