package com.suavoz.report.controller.requests;

import com.suavoz.report.domain.*;
import com.suavoz.report.gateways.persistence.impl.mysql.entities.AgeGroupEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReportRequest {

    private String description;
    private AgeGroupRequest ageGroup;
    private GenreRequest genre;
    private ViolenceTypeRequest violenceType;
    private ZoneRequest zone;

    public Report toDomain() {
        return Report.builder()
                .description(description)
                .ageGroup(ageGroup.toDomain())
                .genre(genre.toDomain())
                .violenceType(violenceType.toDomain())
                .zone(zone.toDomain())
                .build();
    }
}
