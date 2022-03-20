package com.suavoz.report.usecases;

import com.suavoz.report.domain.Report;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.ReportPersistenceGateway;
import com.suavoz.report.usecases.validators.UpdateReportValidator;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateReport {

    private final ReportPersistenceGateway reportPersistenceGateway;
    private final UpdateReportValidator updateReportValidator;

    public Report execute(Report report) {
        val validationErrors = updateReportValidator.validate(report);

        if (!validationErrors.isEmpty()) {
            throw new ValidationExecption(validationErrors);
        }

        return reportPersistenceGateway.save(report);
    }

}
