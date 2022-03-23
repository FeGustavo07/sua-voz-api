package com.suavoz.report.controllers;

import com.suavoz.report.controllers.requests.AgeGroupRequest;
import com.suavoz.report.controllers.responses.AgeGroupResponse;
import com.suavoz.report.domain.AgeGroup;
import com.suavoz.report.usecases.ageGroup.CreateAgeGroup;
import com.suavoz.report.usecases.ageGroup.DeleteAgeGroup;
import com.suavoz.report.usecases.ageGroup.ListAgeGroups;
import com.suavoz.report.usecases.ageGroup.UpdateAgeGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ageGroup")
@RequiredArgsConstructor
public class AgeGroupController {

    private final CreateAgeGroup createAgeGroup;
    private final UpdateAgeGroup updateAgeGroup;
    private final ListAgeGroups listAgeGroups;
    private final DeleteAgeGroup deleteAgeGroup;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgeGroupResponse createAgeGroup(@RequestBody AgeGroupRequest ageGroupRequest) {
        AgeGroup ageGroup = ageGroupRequest.toDomain();
        AgeGroup savedAgeGroup = createAgeGroup.execute(ageGroup);
        return new AgeGroupResponse(savedAgeGroup);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AgeGroupResponse updateAgeGroup(@PathVariable("id") Long id, @RequestBody AgeGroupRequest ageGroupRequest) {
        AgeGroup ageGroup = ageGroupRequest.toDomain();
        ageGroup.setId(id);
        AgeGroup savedAgeGroup = updateAgeGroup.execute(ageGroup);
        return new AgeGroupResponse(savedAgeGroup);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AgeGroupResponse> listAgeGroups() {
        List<AgeGroup> ageGroups = listAgeGroups.execute();
        return ageGroups.stream().map(AgeGroupResponse::new).collect(Collectors.toList());
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAgeGroup(@PathVariable("id") Long id) {
        AgeGroup ageGroup = AgeGroup.builder().build();
        ageGroup.setId(id);
        deleteAgeGroup.execute(ageGroup);
    }

}
