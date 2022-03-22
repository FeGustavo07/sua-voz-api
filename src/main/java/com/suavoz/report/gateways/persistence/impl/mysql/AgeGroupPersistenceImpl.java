package com.suavoz.report.gateways.persistence.impl.mysql;

import com.suavoz.report.domain.AgeGroup;
import com.suavoz.report.gateways.persistence.AgeGroupPersistenceGateway;
import com.suavoz.report.gateways.persistence.impl.mysql.entities.AgeGroupEntity;
import com.suavoz.report.gateways.persistence.impl.mysql.repository.AgeGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AgeGroupPersistenceImpl implements AgeGroupPersistenceGateway {

    private final AgeGroupRepository ageGroupRepository;

    @Override
    public AgeGroup save(AgeGroup ageGroup) {
        AgeGroupEntity ageGroupEntity = new AgeGroupEntity(ageGroup);
        AgeGroupEntity entity = ageGroupRepository.save(ageGroupEntity);
        return entity.toDomain(false);
    }

    @Override
    public void delete(AgeGroup ageGroup) {
        ageGroupRepository.deleteById(ageGroup.getId());
    }

    @Override
    public List<AgeGroup> findAll() {
        return ageGroupRepository.findAll().stream().map(ageGroup -> ageGroup.toDomain(false)).collect(Collectors.toList());
    }
}
