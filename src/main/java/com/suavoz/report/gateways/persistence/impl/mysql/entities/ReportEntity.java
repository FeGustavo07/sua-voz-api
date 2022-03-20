package com.suavoz.report.gateways.persistence.impl.mysql.entities;

import javax.persistence.*;

@Entity
@Table
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
}
