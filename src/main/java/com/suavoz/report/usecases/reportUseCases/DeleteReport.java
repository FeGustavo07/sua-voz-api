package com.suavoz.report.usecases.reportUseCases;

import com.suavoz.report.domain.Report;
import com.suavoz.report.gateways.persistence.ReportPersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteReport {

    private final ReportPersistenceGateway reportPersistenceGateway;

    public void execute(Report report) {
        reportPersistenceGateway.delete(report);
    }
}
