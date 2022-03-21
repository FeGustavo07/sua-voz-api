package com.suavoz.report.gateways.persistence.impl.mysql;

import com.suavoz.report.domain.Report;
import com.suavoz.report.gateways.persistence.ReportPersistenceGateway;
import com.suavoz.report.gateways.persistence.impl.mysql.entities.GenreEntity;
import com.suavoz.report.gateways.persistence.impl.mysql.entities.ReportEntity;
import com.suavoz.report.gateways.persistence.impl.mysql.repository.GenreRepository;
import com.suavoz.report.gateways.persistence.impl.mysql.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReportPersistenceImpl implements ReportPersistenceGateway {

    private final ReportRepository reportRepository;
    private final GenreRepository genreRepository;

    @Override
    public Report save(Report report) {
        ReportEntity entity = new ReportEntity(report);
        GenreEntity genre = genreRepository.findById(report.getGenre().getId()).orElse(entity.getGenre());
        entity.setGenre(genre);
        ReportEntity reportEntity = reportRepository.save(entity);
        return reportEntity.toDomain();
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
