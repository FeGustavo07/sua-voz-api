package com.suavoz.report.controller.requests;

import com.suavoz.report.domain.Zone;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

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
