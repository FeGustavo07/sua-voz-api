package com.suavoz.report.gateways.persistence.impl.mysql.repository;

import com.suavoz.report.gateways.persistence.impl.mysql.entities.AgeGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgeGroupRepository extends JpaRepository<AgeGroupEntity, Long> {
}
