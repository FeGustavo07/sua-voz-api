package com.suavoz.report.validators.ageGroupValidator;

import com.suavoz.report.domain.AgeGroup;
import com.suavoz.report.gateways.persistence.AgeGroupPersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DeleteAgeGroupValidator {

    private final AgeGroupPersistenceGateway ageGroupPersistenceGateway;

    public List<String> validate(AgeGroup ageGroup) {
        List<String> validationErrors = new ArrayList<>();
        boolean existsAgeGroup = ageGroupPersistenceGateway.existsById(ageGroup.getId());

        if (!existsAgeGroup) {
            validationErrors.add("AgeGroup doesn't exists");
        }

        if (ageGroup.getId() == null) {
            validationErrors.add("Id is null");
        }

        return validationErrors;
    }
}
