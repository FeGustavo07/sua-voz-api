package com.suavoz.report.gateways.persistence.impl.mysql.entities;

import javax.persistence.*;

@Entity
@Table
public class ViolenceTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String type;
}
