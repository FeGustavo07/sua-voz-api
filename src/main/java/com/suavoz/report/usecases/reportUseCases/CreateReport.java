package com.suavoz.report.usecases.reportUseCases;

import com.suavoz.report.domain.Report;
import com.suavoz.report.gateways.persistence.ReportPersistenceGateway;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class CreateReport {

    private final ReportPersistenceGateway reportPersistenceGateway;

    public Report execute(Report report) {
        return reportPersistenceGateway.save(report);
    }
}
