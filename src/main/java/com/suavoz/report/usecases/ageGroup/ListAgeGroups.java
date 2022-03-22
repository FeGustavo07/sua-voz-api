package com.suavoz.report.usecases.ageGroup;

import com.suavoz.report.domain.AgeGroup;
import com.suavoz.report.gateways.persistence.AgeGroupPersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListAgeGroups {

    private final AgeGroupPersistenceGateway ageGroupPersistenceGateway;

    public List<AgeGroup> execute() {
        return ageGroupPersistenceGateway.findAll();
    }
}
