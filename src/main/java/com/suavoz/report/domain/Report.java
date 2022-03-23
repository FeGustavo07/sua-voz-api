package com.suavoz.report.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Report {
    private Long id;
    private String description;
    private String email;
    private AgeGroup ageGroup;
    private Genre genre;
    private ViolenceType violenceType;
    private Zone zone;
}
