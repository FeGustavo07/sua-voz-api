package com.suavoz.report.controller.responses;

import com.suavoz.report.domain.Zone;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ZoneResponse {
    private Long id;
    private String name;

    public ZoneResponse(Zone zone) {
        id = zone.getId();
        name = zone.getName();
    }
}
