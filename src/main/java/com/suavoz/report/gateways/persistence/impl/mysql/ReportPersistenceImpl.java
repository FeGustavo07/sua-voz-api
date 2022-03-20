package com.suavoz.report.gateways.persistence.impl.mysql;

import com.suavoz.report.domain.Report;
import com.suavoz.report.gateways.persistence.ReportPersistenceGateway;
import com.suavoz.report.gateways.persistence.impl.mysql.repository.MySqlRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReportPersistenceImpl implements ReportPersistenceGateway {

    private final MySqlRepository mySqlRepository;

    @Override
    public Report save(Report report) {
        return null;
    }

    @Override
    public void delete(Report report) {

    }

    @Override
    public List<Report> findAll() {
        return null;
    }
}
