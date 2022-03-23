package com.suavoz.report.gateways.persistence.impl.mysql.entities;

import com.suavoz.report.domain.Report;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TB_REPORT")
@NoArgsConstructor
public class ReportEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "EMAIL")
    private String email;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_AGE_GROUP", referencedColumnName = "ID")
    private AgeGroupEntity ageGroup;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_GENRE", referencedColumnName = "ID")
    private GenreEntity genre;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_VIOLENCE_TYPE", referencedColumnName = "ID")
    private ViolenceTypeEntity violenceType;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_ZONE ", referencedColumnName = "ID")
    private ZoneEntity zone;

    public ReportEntity(Report report){
        id = report.getId();
        description = report.getDescription();
        email = report.getEmail();
        ageGroup = new AgeGroupEntity(report.getAgeGroup());
        genre = new GenreEntity(report.getGenre());
        violenceType = new ViolenceTypeEntity(report.getViolenceType());
        zone = new ZoneEntity(report.getZone());
    }

    public Report toDomain() {

        return Report.builder()
                .id(id)
                .description(description)
                .email(email)
                .violenceType(violenceType.toDomain(false))
                .ageGroup(ageGroup.toDomain(false))
                .genre(genre.toDomain(false))
                .zone(zone.toDomain(false))
                .build();
    }
}
