package com.suavoz.report.controller.requests;

import com.suavoz.report.domain.ViolenceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ViolenceTypeRequest {
    private Long id;
    private String type;

    public ViolenceType toDomain() {
        return ViolenceType.builder()
                .id(id)
                .type(type)
                .build();
    }
}
