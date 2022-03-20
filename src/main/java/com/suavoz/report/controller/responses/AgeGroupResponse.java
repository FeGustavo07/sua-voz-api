package com.suavoz.report.controller.responses;

import com.suavoz.report.domain.AgeGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AgeGroupResponse {
    private Long id;
    private String ages;

    public AgeGroupResponse(AgeGroup ageGroup) {
        id = ageGroup.getId();
        ages = ageGroup.getAges();
    }
}
