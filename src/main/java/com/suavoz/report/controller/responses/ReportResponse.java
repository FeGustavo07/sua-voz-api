package com.suavoz.report.controller.responses;

import com.suavoz.report.domain.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReportResponse {

    private Long id;
    private String description;
    private AgeGroup ageGroup;
    private Genre genre;
    private ViolenceType violenceType;
    private Zone zone;

    public ReportResponse(Report report) {
        id = report.getId();
        description = report.getDescription();
        ageGroup = getAgeGroup();
        genre = getGenre();
        violenceType = getViolenceType();
        zone = getZone();
    }
}
