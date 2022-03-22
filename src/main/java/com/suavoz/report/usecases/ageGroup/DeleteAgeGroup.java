package com.suavoz.report.usecases.ageGroup;

import com.suavoz.report.domain.AgeGroup;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.AgeGroupPersistenceGateway;
import com.suavoz.report.validators.ageGroupValidator.DeleteAgeGroupValidator;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteAgeGroup {

    private final AgeGroupPersistenceGateway ageGroupPersistenceGateway;
    private final DeleteAgeGroupValidator deleteAgeGroupValidator;

    public void execute(AgeGroup ageGroup) {
        val validationErrors = deleteAgeGroupValidator.validate(ageGroup);

        if (!validationErrors.isEmpty()) {
            throw new ValidationExecption(validationErrors);
        }

        ageGroupPersistenceGateway.delete(ageGroup);
    }
}
