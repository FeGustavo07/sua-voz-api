package com.suavoz.report.gateways.persistence.impl.mysql.repository;

import com.suavoz.report.gateways.persistence.impl.mysql.entities.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySqlRepository extends JpaRepository<ReportEntity, Long> {
}
