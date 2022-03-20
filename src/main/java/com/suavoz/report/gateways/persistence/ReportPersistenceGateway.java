package com.suavoz.report.gateways.persistence;

import com.suavoz.report.domain.Report;

import java.util.List;

public interface ReportPersistenceGateway {

    Report save(Report report);

    void delete(Report report);

    List<Report> findAll();
}
