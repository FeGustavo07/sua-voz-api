package com.suavoz.report.gateways.persistence.impl.mysql.entities;

import com.suavoz.report.domain.Report;
import com.suavoz.report.domain.Zone;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "TB_ZONE")
@NoArgsConstructor
public class ZoneEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "zone")
    private List<ReportEntity> reportEntities = new ArrayList<>();

    public ZoneEntity(Zone zone) {
        id = zone.getId();
        name = zone.getName();
    }

    public Zone toDomain(boolean loadReports) {
        List<Report> reports = loadReports ? reportEntities.stream().map(ReportEntity::toDomain)
                .collect(Collectors.toList()) : List.of();
        return Zone.builder()
                .id(id)
                .name(name)
                .reports(reports)
                .build();
    }
}
