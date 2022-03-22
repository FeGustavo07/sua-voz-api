package com.suavoz.report.usecases.report;

import com.suavoz.report.domain.Report;
import com.suavoz.report.gateways.persistence.ReportPersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListReports {

    private final ReportPersistenceGateway reportPersistenceGateway;

    public List<Report> execute() {
        return reportPersistenceGateway.findAll();
    }

}
