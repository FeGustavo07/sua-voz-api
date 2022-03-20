package com.suavoz.report.gateways.persistence.impl.mysql.entities;

import com.suavoz.report.domain.Zone;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
public class ZoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public ZoneEntity(Zone zone) {
        id = zone.getId();
        name = zone.getName();
    }

    public Zone toDomain() {
        return Zone.builder()
                .id(id)
                .name(name)
                .build();
    }
}
