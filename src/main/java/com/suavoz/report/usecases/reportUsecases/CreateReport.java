package com.suavoz.report.usecases.reportUsecases;

import com.suavoz.report.domain.Report;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.ReportPersistenceGateway;
import com.suavoz.report.usecases.validators.CreateReportValidator;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateReport {

    private final ReportPersistenceGateway reportPersistenceGateway;
    private final CreateReportValidator createReportValidator;

    public Report execute(Report report) {
        val validationErrors = createReportValidator.validate(report);

        if (!validationErrors.isEmpty()) {
            throw new ValidationExecption(validationErrors);
        }
        return reportPersistenceGateway.save(report);
    }
}
