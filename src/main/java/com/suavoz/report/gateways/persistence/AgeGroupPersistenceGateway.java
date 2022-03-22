package com.suavoz.report.gateways.persistence;

import com.suavoz.report.domain.AgeGroup;

import java.util.List;

public interface AgeGroupPersistenceGateway {

    AgeGroup save(AgeGroup ageGroup);

    void delete(AgeGroup ageGroup);

    List<AgeGroup> findAll();

    boolean existsById(Long id);
}
