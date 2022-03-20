package com.suavoz.report.controller.requests;

import com.suavoz.report.domain.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReportRequest {

    private String description;
    private AgeGroup ageGroup;
    private Genre genre;
    private ViolenceType violenceType;
    private Zone zone;

    public Report toDomain() {
        return Report.builder()
                .description(description)
                .ageGroup(ageGroup)
                .genre(genre)
                .violenceType(violenceType)
                .zone(zone)
                .build();
    }
}
