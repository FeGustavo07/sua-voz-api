package com.suavoz.report.controllers.requests;

import com.suavoz.report.domain.Zone;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ZoneRequest {

    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(required = true, value = "Zone name", example = "Sul")
    private String name;

    public Zone toDomain() {
        return Zone.builder()
                .id(id)
                .name(name)
                .build();
    }
}
