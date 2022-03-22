package com.suavoz.report.usecases.violenceType;

import com.suavoz.report.domain.ViolenceType;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.ViolenceTypePersistenceGateway;
import com.suavoz.report.validators.violenceTypeValidator.DeleteVtValidator;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteViolenceType {

    private final ViolenceTypePersistenceGateway violenceTypePersistenceGateway;
    private final DeleteVtValidator deleteVtValidator;


    public void execute(ViolenceType violenceType) {
        val validationErrors = deleteVtValidator.validate(violenceType);

        if (!validationErrors.isEmpty()) {
            throw new ValidationExecption(validationErrors);
        }

        violenceTypePersistenceGateway.delete(violenceType);
    }

}
