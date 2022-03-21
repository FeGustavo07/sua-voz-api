package com.suavoz.report.gateways.persistence.impl.mysql;

import com.suavoz.report.domain.Report;
import com.suavoz.report.gateways.persistence.ReportPersistenceGateway;
import com.suavoz.report.gateways.persistence.impl.mysql.entities.*;
import com.suavoz.report.gateways.persistence.impl.mysql.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReportPersistenceImpl implements ReportPersistenceGateway {

    private final ReportRepository reportRepository;
    private final GenreRepository genreRepository;
    private final ZoneRepository zoneRepository;
    private final ViolenceTypeRepository violenceTypeRepository;
    private final AgeGroupRepository ageGroupRepository;

    @Override
    public Report save(Report report) {
        ReportEntity entity = new ReportEntity(report);
        setEntityProps(report, entity);
        ReportEntity reportEntity = reportRepository.save(entity);
        return reportEntity.toDomain();
    }

    private void setEntityProps(Report report, ReportEntity entity) {
        GenreEntity genre = report.getGenre().getId() != null ? genreRepository.findById(report.getGenre().getId()).orElse(entity.getGenre()) : entity.getGenre();
        AgeGroupEntity ageGroup = report.getAgeGroup().getId() != null ? ageGroupRepository.findById(report.getAgeGroup().getId()).orElse(entity.getAgeGroup()) : entity.getAgeGroup();
        ZoneEntity zone = report.getZone().getId() != null ? zoneRepository.findById(report.getZone().getId()).orElse(entity.getZone()) : entity.getZone();
        ViolenceTypeEntity violenceType = report.getViolenceType().getId() != null ? violenceTypeRepository.findById(report.getViolenceType().getId()).orElse(entity.getViolenceType()) : entity.getViolenceType();
        entity.setGenre(genre);
        entity.setAgeGroup(ageGroup);
        entity.setZone(zone);
        entity.setViolenceType(violenceType);
    }

    @Override
    public void delete(Report report) {
        reportRepository.deleteById(report.getId());
    }

    @Override
    public List<Report> findAll() {
        return reportRepository.findAll().stream().map(ReportEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public boolean existsById(Long id) {
        return reportRepository.existsById(id);
    }
}
