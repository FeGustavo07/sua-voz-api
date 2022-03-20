package com.suavoz.report.controller.requests;

import com.suavoz.report.domain.AgeGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AgeGroupRequest {
    private Long id;
    private String ages;

    public AgeGroup toDomain() {
        return AgeGroup.builder()
                .id(id)
                .ages(ages)
                .build();
    }

}
