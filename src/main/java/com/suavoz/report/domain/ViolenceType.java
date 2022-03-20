package com.suavoz.report.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ViolenceType {
    private Long id;
    private String type;
}
