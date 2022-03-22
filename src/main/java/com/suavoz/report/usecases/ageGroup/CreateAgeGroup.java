package com.suavoz.report.usecases.ageGroup;

import com.suavoz.report.domain.AgeGroup;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.AgeGroupPersistenceGateway;
import com.suavoz.report.validators.ageGroupValidator.CreateAndUpdateAgeGroupValidator;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAgeGroup {

    private final AgeGroupPersistenceGateway ageGroupPersistenceGateway;
    private final CreateAndUpdateAgeGroupValidator createAndUpdateAgeGroupValidator;

    public AgeGroup execute(AgeGroup ageGroup) {
        val validationErros = createAndUpdateAgeGroupValidator.validate(ageGroup);

        if (!validationErros.isEmpty()) {
            throw new ValidationExecption(validationErros);
        }

        return ageGroupPersistenceGateway.save(ageGroup);
    }
}
