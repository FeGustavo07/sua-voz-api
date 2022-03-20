package com.suavoz.report.gateways.persistence;

import com.suavoz.report.domain.Report;

public interface ReportPersistenceGateway {

    Report save(Report report);

    void delete(Report report);

}
