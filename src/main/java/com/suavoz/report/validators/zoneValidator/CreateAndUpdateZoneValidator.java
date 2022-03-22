package com.suavoz.report.validators.zoneValidator;

import com.suavoz.report.domain.AgeGroup;
import com.suavoz.report.domain.Zone;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateAndUpdateZoneValidator {

    public List<String> validate(Zone zone) {
        List<String> validationErrors = new ArrayList<>();

        if (zone == null) {
            validationErrors.add("Zone is null");
        }

        if (!StringUtils.hasText(zone.getName())) {
            validationErrors.add("Zone Name is empty");
        }

        return validationErrors;
    }
}
