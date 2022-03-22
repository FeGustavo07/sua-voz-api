package com.suavoz.report.gateways.persistence;

import com.suavoz.report.domain.ViolenceType;

import java.util.List;

public interface ViolenceTypePersistenceGateway {

    ViolenceType save(ViolenceType violenceType);

    void delete(ViolenceType violenceType);

    List<ViolenceType> findAll();

    boolean existsById(Long id);
}
