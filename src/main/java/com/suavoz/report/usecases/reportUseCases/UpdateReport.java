package com.suavoz.report.usecases.reportUseCases;

import com.suavoz.report.domain.Report;
import com.suavoz.report.gateways.persistence.ReportPersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateReport {

    private final ReportPersistenceGateway reportPersistenceGateway;

    public Report execute(Report report) {
        return reportPersistenceGateway.save(report);
    }

}
