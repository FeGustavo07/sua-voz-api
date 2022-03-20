package com.suavoz.report.gateways.persistence.impl.mysql.entities;

import com.suavoz.report.domain.Genre;
import com.suavoz.report.domain.ViolenceType;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
public class ViolenceTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String type;

    public ViolenceTypeEntity(ViolenceType violenceType) {
        id = violenceType.getId();
        type = violenceType.getType();
    }

    public ViolenceType toDomain() {
        return ViolenceType.builder()
                .id(id)
                .type(type)
                .build();
    }
}
