package com.suavoz.report.gateways.persistence.impl.mysql.entities;

import com.suavoz.report.controller.requests.AgeGroupRequest;
import com.suavoz.report.domain.AgeGroup;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
public class AgeGroupEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ages;

    public AgeGroupEntity(AgeGroup ageGroup) {
        id = ageGroup.getId();
        ages = ageGroup.getAges();
    }

    public AgeGroupEntity(AgeGroupRequest ageGroupRequest) {
        id = ageGroupRequest.getId();
        ages = ageGroupRequest.getAges();
    }

    public AgeGroup toDomain() {
        return AgeGroup.builder()
                .id(id)
                .ages(ages)
                .build();
    }
}
