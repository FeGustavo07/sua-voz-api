package com.suavoz.report.gateways.persistence;

import com.suavoz.report.domain.Report;

import java.util.List;
import java.util.Optional;

public interface ReportPersistenceGateway {

    Report save(Report report);

    void delete(Report report);

    List<Report> findAll();

    Optional<Report> findById(Long id);

    boolean existsById(Long id);
}
