package com.suavoz.report.gateways.persistence;

import com.suavoz.report.domain.Report;
import com.suavoz.report.domain.Zone;

import java.util.List;

public interface ZonePersistenceGateway {

    Zone save(Zone zone);

    void delete(Zone zone);

    List<Zone> findAll();

    boolean existsById(Long id);
}
