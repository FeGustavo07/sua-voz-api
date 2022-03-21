package com.suavoz.report.gateways.persistence.impl.mysql.entities;

import com.suavoz.report.domain.Report;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
public class ReportEntity {

    //TODO Verificar relacionameto das tabelas
    //produtos

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "ID_AGE_GROUP", referencedColumnName = "id")
//    @OneToOne(cascade = CascadeType.ALL)
    private AgeGroupEntity ageGroup;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "ID_GENRE", referencedColumnName = "id")
//    @OneToOne(cascade = CascadeType.ALL)
    private GenreEntity genre;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "ID_VIOLENCE_TYPE", referencedColumnName = "id")
//    @OneToOne(cascade = CascadeType.ALL)
    private ViolenceTypeEntity violenceType;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "ID_ZONE", referencedColumnName = "id")
//    @OneToOne(cascade = CascadeType.ALL)
    private ZoneEntity zone;

    public ReportEntity(Report report){
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
