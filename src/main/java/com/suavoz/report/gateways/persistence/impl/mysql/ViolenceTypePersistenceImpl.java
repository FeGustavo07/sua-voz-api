package com.suavoz.report.gateways.persistence.impl.mysql;

import com.suavoz.report.domain.ViolenceType;
import com.suavoz.report.gateways.persistence.ViolenceTypePersistenceGateway;
import com.suavoz.report.gateways.persistence.impl.mysql.entities.ViolenceTypeEntity;
import com.suavoz.report.gateways.persistence.impl.mysql.repository.ViolenceTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ViolenceTypePersistenceImpl implements ViolenceTypePersistenceGateway {

    private final ViolenceTypeRepository violenceTypeRepository;

    @Override
    public ViolenceType save(ViolenceType violenceType) {
        ViolenceTypeEntity violenceTypeEntity = new ViolenceTypeEntity(violenceType);
        ViolenceTypeEntity entity = violenceTypeRepository.save(violenceTypeEntity);
        return entity.toDomain(false);
    }

    @Override
    public void delete(ViolenceType violenceType) {
        violenceTypeRepository.deleteById(violenceType.getId());
    }

    @Override
    public List<ViolenceType> findAll() {
        return violenceTypeRepository.findAll().stream().map(violenceType -> violenceType.toDomain(false)).collect(Collectors.toList());
    }
}
