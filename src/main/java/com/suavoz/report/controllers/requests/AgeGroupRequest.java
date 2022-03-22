package com.suavoz.report.controllers.requests;

import com.suavoz.report.domain.AgeGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AgeGroupRequest {

    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(required = true, value = "Ages", example = "30-40")
    private String ages;

    public AgeGroup toDomain() {
        return AgeGroup.builder()
                .id(id)
                .ages(ages)
                .build();
    }

}
