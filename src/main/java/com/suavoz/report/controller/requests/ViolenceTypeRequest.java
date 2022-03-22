package com.suavoz.report.controller.requests;

import com.suavoz.report.domain.ViolenceType;
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
public class ViolenceTypeRequest {

    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(required = true, value = "Type", example = "Verbal")
    private String type;

    public ViolenceType toDomain() {
        return ViolenceType.builder()
                .id(id)
                .type(type)
                .build();
    }
}
