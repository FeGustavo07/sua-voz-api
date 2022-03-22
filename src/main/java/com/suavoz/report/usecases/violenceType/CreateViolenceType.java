package com.suavoz.report.usecases.violenceType;

import com.suavoz.report.domain.ViolenceType;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.ViolenceTypePersistenceGateway;
import com.suavoz.report.validators.violenceTypeValidator.CreateAndUpdateVtValidator;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateViolenceType {

    private final ViolenceTypePersistenceGateway violenceTypePersistenceGateway;
    private final CreateAndUpdateVtValidator createAndUpdateVtValidator;

    public ViolenceType execute(ViolenceType violenceType) {
        val validationsErrors = createAndUpdateVtValidator.validate(violenceType);

        if (!validationsErrors.isEmpty()) {
            throw new ValidationExecption(validationsErrors);
        }

        return violenceTypePersistenceGateway.save(violenceType);
    }

}
