package com.suavoz.report.usecases.ageGroup;

import com.suavoz.report.domain.AgeGroup;
import com.suavoz.report.gateways.persistence.AgeGroupPersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAgeGroup {

    private final AgeGroupPersistenceGateway ageGroupPersistenceGateway;

    public AgeGroup execute(AgeGroup ageGroup) {
        return ageGroupPersistenceGateway.save(ageGroup);
    }
}
