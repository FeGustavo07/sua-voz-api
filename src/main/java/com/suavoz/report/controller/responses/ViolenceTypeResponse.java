package com.suavoz.report.controller.responses;

import com.suavoz.report.domain.ViolenceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ViolenceTypeResponse {
    private Long id;
    private String type;

    public ViolenceTypeResponse(ViolenceType violenceType) {
        id = violenceType.getId();
        type = violenceType.getType();
    }
}
