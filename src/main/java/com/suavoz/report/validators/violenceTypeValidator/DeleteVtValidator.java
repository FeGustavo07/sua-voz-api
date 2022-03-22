package com.suavoz.report.validators.violenceTypeValidator;

import com.suavoz.report.domain.AgeGroup;
import com.suavoz.report.domain.ViolenceType;
import com.suavoz.report.gateways.persistence.ViolenceTypePersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DeleteVtValidator {

    private final ViolenceTypePersistenceGateway violenceTypePersistenceGateway;

    public List<String> validate(ViolenceType violenceType) {
        List<String> validationErrors = new ArrayList<>();
        boolean existsViolenceType= violenceTypePersistenceGateway.existsById(violenceType.getId());

        if (!existsViolenceType) {
            validationErrors.add("Violence Type doesn't exists");
        }

        if (violenceType.getId() == null) {
            validationErrors.add("Id is null");
        }

        return validationErrors;
    }

}
