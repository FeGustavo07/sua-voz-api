package com.suavoz.report.controller.requests;

import com.suavoz.report.domain.Zone;
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
    private Long id;
    private String name;

    public Zone toDomain() {
        return Zone.builder()
                .id(id)
                .name(name)
                .build();
    }
}
