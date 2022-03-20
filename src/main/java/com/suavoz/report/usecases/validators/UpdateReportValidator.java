package com.suavoz.report.usecases.validators;

import com.suavoz.report.domain.Report;
import com.suavoz.report.gateways.persistence.ReportPersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UpdateReportValidator {

    private final ReportPersistenceGateway reportPersistenceGateway;

    public List<String> validate(Report report) {
        List<String> validationErrors = new ArrayList<>();
        boolean existsReport = reportPersistenceGateway.existsById(report.getId());

        if (!existsReport) {
            validationErrors.add("Report não existe");
        }

        if (report.getId() == null) {
            validationErrors.add("Id não pode ser nulo");
        }

        return validationErrors;
    }
}
