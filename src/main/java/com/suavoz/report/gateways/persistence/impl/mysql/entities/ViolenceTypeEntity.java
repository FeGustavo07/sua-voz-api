package com.suavoz.report.gateways.persistence.impl.mysql.entities;

import com.suavoz.report.domain.Report;
import com.suavoz.report.domain.ViolenceType;
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
@Table
@NoArgsConstructor
public class ViolenceTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String type;

    @OneToMany(mappedBy = "violenceType")
    private List<ReportEntity> reportEntities = new ArrayList<>();

    public ViolenceTypeEntity(ViolenceType violenceType) {
        id = violenceType.getId();
        type = violenceType.getType();
    }

    public ViolenceType toDomain(boolean loadReports) {
        List<Report> reports = loadReports ? reportEntities.stream().map(ReportEntity::toDomain)
                .collect(Collectors.toList()) : List.of();
        return ViolenceType.builder()
                .id(id)
                .type(type)
                .reports(reports)
                .build();
    }
}
