package com.suavoz.report.usecases.zone;

import com.suavoz.report.domain.Zone;
import com.suavoz.report.gateways.persistence.ZonePersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListZones {

    private final ZonePersistenceGateway zonePersistenceGateway;

    public List<Zone> execute() {
        return zonePersistenceGateway.findAll();
    }
}
