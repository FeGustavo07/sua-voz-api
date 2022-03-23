package com.suavoz.report.usecases.ageGroup;

import com.suavoz.report.domain.AgeGroup;
import com.suavoz.report.gateways.persistence.AgeGroupPersistenceGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.ArrayList;
import java.util.List;

@MockitoSettings
class ListAgeGroupsTest {

    @InjectMocks
    ListAgeGroups listAgeGroups;

    @Mock
    AgeGroupPersistenceGateway ageGroupPersistenceGateway;

    @Test
    void ShouldReturnAListWhenFindAgeGroups() {
        AgeGroup ageGroup = AgeGroup.builder().build();

        List<AgeGroup> ageGroups = new ArrayList<>();

        ageGroups.add(ageGroup);
        ageGroups.add(ageGroup);

        Mockito.when(ageGroupPersistenceGateway.findAll()).thenReturn(List.of(ageGroup, ageGroup));

        List<AgeGroup> ageGroupList = ageGroupPersistenceGateway.findAll();

        Assertions.assertEquals(ageGroups, ageGroupList);
        Mockito.verify(ageGroupPersistenceGateway, Mockito.times(1)).findAll();
    }

    @Test
    void ShouldReturnAnEmptyListWhenDontFindAgeGroups() {
        List<AgeGroup> ageGroups = new ArrayList<>();

        List<AgeGroup> ageGroupList = listAgeGroups.execute();

        Assertions.assertEquals(ageGroups, ageGroupList);
        Mockito.verify(ageGroupPersistenceGateway, Mockito.times(1)).findAll();
    }

}