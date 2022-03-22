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
public class UpdateViolenceType {

    private final ViolenceTypePersistenceGateway violenceTypePersistenceGateway;
    private final CreateAndUpdateVtValidator createAndUpdateVtValidator;

    public ViolenceType execute(ViolenceType violenceType) {
        val validationErrors = createAndUpdateVtValidator.validate(violenceType);

        if (!validationErrors.isEmpty()) {
            throw new ValidationExecption(validationErrors);
        }

        return violenceTypePersistenceGateway.save(violenceType);
    }
}
