package com.suavoz.report.controllers.responses;

import com.suavoz.report.domain.ViolenceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
