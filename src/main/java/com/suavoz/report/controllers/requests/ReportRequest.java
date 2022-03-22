package com.suavoz.report.controllers.requests;

import com.suavoz.report.domain.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReportRequest {

    @ApiModelProperty(required = true, value = "Description", example = "Relato de racismo")
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
