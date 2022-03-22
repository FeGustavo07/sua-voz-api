package com.suavoz.report.validators.reportValidator;

import com.suavoz.report.domain.Report;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CreateReportValidator {

    public List<String> validate(Report report) {
        List<String> validationErrors = new ArrayList<>();

        if (report == null) {
            validationErrors.add("Report is null");
        }

        GenericValidator.validations(report, validationErrors);

        return validationErrors;
    }

}
