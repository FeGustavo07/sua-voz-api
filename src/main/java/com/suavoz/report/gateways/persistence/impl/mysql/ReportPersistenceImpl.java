package com.suavoz.report.gateways.persistence.impl.mysql;

import com.suavoz.report.domain.Report;
import com.suavoz.report.gateways.persistence.ReportPersistenceGateway;
import com.suavoz.report.gateways.persistence.impl.mysql.entities.ReportEntity;
import com.suavoz.report.gateways.persistence.impl.mysql.repository.MySqlRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ReportPersistenceImpl implements ReportPersistenceGateway {

    private final MySqlRepository mySqlRepository;

    @Override
    public Report save(Report report) {
        ReportEntity reportEntity = mySqlRepository.save(new ReportEntity(report));
        return reportEntity.toDomain();
    }

    @Override
    public void delete(Report report) {
        mySqlRepository.deleteById(report.getId());
    }

    @Override
    public List<Report> findAll() {
        return mySqlRepository.findAll().stream().map(ReportEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public boolean existsById(Long id) {
        return mySqlRepository.existsById(id);
    }
}
