package com.suavoz.report.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AgeGroup {
    private Long id;
    private String ages;
    private List<Report> reports;
}
