package com.suavoz.report.controller;

import com.suavoz.report.controller.requests.ZoneRequest;
import com.suavoz.report.controller.responses.ZoneResponse;
import com.suavoz.report.domain.Zone;
import com.suavoz.report.usecases.zoneUseCases.CreateZone;
import com.suavoz.report.usecases.zoneUseCases.DeleteZone;
import com.suavoz.report.usecases.zoneUseCases.ListZones;
import com.suavoz.report.usecases.zoneUseCases.UpdateZone;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zone")
@RequiredArgsConstructor
public class ZoneController {

    private final CreateZone createZone;
    private final ListZones listZones;
    private final DeleteZone deleteZone;
    private final UpdateZone updateZone;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ZoneResponse createZone(@RequestBody ZoneRequest zoneRequest) {
        Zone zone = zoneRequest.toDomain();
        Zone savedZone = createZone.execute(zone);
        return new ZoneResponse(savedZone);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ZoneResponse updateZone(@PathVariable("id") Long id, @RequestBody ZoneRequest zoneRequest) {
        Zone zone = zoneRequest.toDomain();
        zone.setId(id);
        Zone savedZone = updateZone.execute(zone);
        return new ZoneResponse(savedZone);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ZoneResponse> listReports() {
        List<Zone> reports = listZones.execute();
        return reports.stream().map(ZoneResponse::new).collect(Collectors.toList());
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteZone(@PathVariable("id") Long id) {
        Zone zone = Zone.builder().build();
        zone.setId(id);
        deleteZone.execute(zone);
    }


}
