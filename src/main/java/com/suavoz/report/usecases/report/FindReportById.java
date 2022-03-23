package com.suavoz.report.usecases.report;

import com.suavoz.report.domain.Report;
import com.suavoz.report.gateways.persistence.ReportPersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindReportById {

    private final ReportPersistenceGateway reportPersistenceGateway;

    public Optional<Report> execute(Long id) {
        return reportPersistenceGateway.findById(id);
    }

}
