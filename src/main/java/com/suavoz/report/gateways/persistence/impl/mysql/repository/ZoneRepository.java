package com.suavoz.report.gateways.persistence.impl.mysql.repository;

import com.suavoz.report.gateways.persistence.impl.mysql.entities.ZoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<ZoneEntity, Long> {
}
