package com.suavoz.report.usecases.validators;

import com.suavoz.report.domain.Report;
import org.springframework.util.StringUtils;

import java.util.List;

public class GenericValidator {

    public static void validations(Report report, List<String> validationErrors) {
        if (!StringUtils.hasText(report.getDescription())) {
            validationErrors.add("Description is empty");
        }

        if (report.getAgeGroup() == null) {
            validationErrors.add("AgeGroup is null");
        }

        if (report.getGenre() == null) {
            validationErrors.add("Genre is null");
        }

        if (report.getViolenceType() == null) {
            validationErrors.add("Violence type is null");
        }

        if (report.getZone() == null) {
            validationErrors.add("Zone is null");
        }
    }
}
