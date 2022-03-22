package com.suavoz.report.gateways.persistence.impl.mysql;

import com.suavoz.report.domain.Zone;
import com.suavoz.report.gateways.persistence.ZonePersistenceGateway;
import com.suavoz.report.gateways.persistence.impl.mysql.entities.ReportEntity;
import com.suavoz.report.gateways.persistence.impl.mysql.entities.ZoneEntity;
import com.suavoz.report.gateways.persistence.impl.mysql.repository.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ZonePersistenceImpl implements ZonePersistenceGateway {

    private final ZoneRepository zoneRepository;

    @Override
    public Zone save(Zone zone) {
        ZoneEntity zoneEntity = new ZoneEntity(zone);
        ZoneEntity entity = zoneRepository.save(zoneEntity);
        return entity.toDomain(false);
    }

    @Override
    public void delete(Zone zone) {
        zoneRepository.deleteById(zone.getId());
    }

    @Override
    public List<Zone> findAll() {
        return zoneRepository.findAll().stream().map(zone -> zone.toDomain(false)).collect(Collectors.toList());
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
