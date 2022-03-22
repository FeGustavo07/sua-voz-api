package com.suavoz.report.validators.violenceTypeValidator;

import com.suavoz.report.domain.AgeGroup;
import com.suavoz.report.domain.ViolenceType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateAndUpdateVtValidator {

    public List<String> validate(ViolenceType violenceType) {
        List<String> validationErrors = new ArrayList<>();

        if (violenceType == null) {
            validationErrors.add("Violence Type is null");
        }

        if (!StringUtils.hasText(violenceType.getType())) {
            validationErrors.add("Type is empty");
        }

        return validationErrors;
    }
}
