package com.suavoz.report.gateways.persistence.impl.mysql.repository;

import com.suavoz.report.gateways.persistence.impl.mysql.entities.ViolenceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViolenceTypeRepository extends JpaRepository<ViolenceTypeEntity, Long> {
}
