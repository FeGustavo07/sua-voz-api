package com.suavoz.report.validators.ageGroupValidator;

import com.suavoz.report.domain.AgeGroup;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateAndUpdateAgeGroupValidator {

    public List<String> validate(AgeGroup ageGroup) {
        List<String> validationErrors = new ArrayList<>();

        if (ageGroup == null) {
            validationErrors.add("AgeGroup is null");
        }

        if (!StringUtils.hasText(ageGroup.getAges())) {
            validationErrors.add("AgeGroup Name is empty");
        }

        return validationErrors;
    }

}
