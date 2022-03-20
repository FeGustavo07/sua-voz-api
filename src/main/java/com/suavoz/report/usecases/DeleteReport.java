package com.suavoz.report.usecases;

import com.suavoz.report.domain.Report;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.ReportPersistenceGateway;
import com.suavoz.report.usecases.validators.DeleteReportValidator;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteReport {

    private final ReportPersistenceGateway reportPersistenceGateway;
    private final DeleteReportValidator deleteReportValidator;

    public void execute(Report report) {
        val validationErrors = deleteReportValidator.validate(report);

        if (!validationErrors.isEmpty()) {
            throw new ValidationExecption(validationErrors);
        }

        reportPersistenceGateway.delete(report);
    }
}
