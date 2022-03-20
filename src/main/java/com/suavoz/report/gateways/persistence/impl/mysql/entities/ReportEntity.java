package com.suavoz.report.gateways.persistence.impl.mysql.entities;

import com.suavoz.report.domain.Report;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
public class ReportEntity {

    //TODO Verificar relacionameto das tabelas

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @ManyToOne()
    private AgeGroupEntity ageGroup;

    @ManyToOne()
    private GenreEntity genre;

    @ManyToOne()
    private ViolenceTypeEntity violenceType;

    @ManyToOne()
    private ZoneEntity zone;

    public ReportEntity(Report report) {
        id = report.getId();
        description = report.getDescription();
        ageGroup = new AgeGroupEntity(report.getAgeGroup());
        genre = new GenreEntity(report.getGenre());
        violenceType = new ViolenceTypeEntity(report.getViolenceType());
        zone = new ZoneEntity(report.getZone());
    }

    public Report toDomain() {
        return Report.builder()
                .id(id)
                .description(description)
                .violenceType(violenceType.toDomain())
                .ageGroup(ageGroup.toDomain())
                .genre(genre.toDomain())
                .zone(zone.toDomain())
                .build();
    }
}
