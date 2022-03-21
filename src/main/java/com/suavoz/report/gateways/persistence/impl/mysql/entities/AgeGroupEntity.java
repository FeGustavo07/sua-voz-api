package com.suavoz.report.gateways.persistence.impl.mysql.entities;

import com.suavoz.report.controller.requests.AgeGroupRequest;
import com.suavoz.report.domain.AgeGroup;
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
public class AgeGroupEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ages;

    @OneToMany(mappedBy = "ageGroup")
    private List<ReportEntity> reportEntities = new ArrayList<>();

    public AgeGroupEntity(AgeGroup ageGroup) {
        id = ageGroup.getId();
        ages = ageGroup.getAges();
    }


    public AgeGroup toDomain() {
        return AgeGroup.builder()
                .id(id)
                .ages(ages)
                .build();
    }
}
