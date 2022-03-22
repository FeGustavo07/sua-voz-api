package com.suavoz.report.controllers;

import com.suavoz.report.controllers.requests.ViolenceTypeRequest;
import com.suavoz.report.controllers.responses.ViolenceTypeResponse;
import com.suavoz.report.domain.ViolenceType;
import com.suavoz.report.usecases.violenceType.CreateViolenceType;
import com.suavoz.report.usecases.violenceType.DeleteViolenceType;
import com.suavoz.report.usecases.violenceType.ListVIolenceTypes;
import com.suavoz.report.usecases.violenceType.UpdateViolenceType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/violenceType")
@RequiredArgsConstructor
public class ViolenceTypeController {

    private final CreateViolenceType createViolenceType;
    private final UpdateViolenceType updateViolenceType;
    private final DeleteViolenceType deleteViolenceType;
    private final ListVIolenceTypes listViolenceTypes;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViolenceTypeResponse createViolenceType(@RequestBody ViolenceTypeRequest violenceTypeRequest) {
        ViolenceType violenceType = violenceTypeRequest.toDomain();
        ViolenceType savedViolenceType = createViolenceType.execute(violenceType);
        return new ViolenceTypeResponse(savedViolenceType);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ViolenceTypeResponse updateViolenceType(@PathVariable("id") Long id, @RequestBody ViolenceTypeRequest violenceTypeRequest) {
        ViolenceType violenceType = violenceTypeRequest.toDomain();
        violenceType.setId(id);
        ViolenceType savedViolenceType = updateViolenceType.execute(violenceType);
        return new ViolenceTypeResponse(savedViolenceType);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ViolenceTypeResponse> listViolenceTypes() {
        List<ViolenceType> violenceTypes = listViolenceTypes.execute();
        return violenceTypes.stream().map(ViolenceTypeResponse::new).collect(Collectors.toList());
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteViolenceType(@PathVariable("id") Long id) {
        ViolenceType violenceType = ViolenceType.builder().build();
        violenceType.setId(id);
        deleteViolenceType.execute(violenceType);
    }

}
