package com.suavoz.report.usecases.violenceType;

import com.suavoz.report.domain.ViolenceType;
import com.suavoz.report.gateways.persistence.ViolenceTypePersistenceGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.ArrayList;
import java.util.List;

@MockitoSettings
class ListVIolenceTypesTest {

    @InjectMocks
    ListVIolenceTypes listVIolenceTypes;

    @Mock
    ViolenceTypePersistenceGateway violenceTypePersistenceGateway;

    @Test
    void ShouldReturnAListWhenFindViolenceType() {
        ViolenceType violenceType = ViolenceType.builder().build();

        List<ViolenceType> violenceTypes = new ArrayList<>();

        violenceTypes.add(violenceType);
        violenceTypes.add(violenceType);

        Mockito.when(violenceTypePersistenceGateway.findAll()).thenReturn(List.of(violenceType, violenceType));

        List<ViolenceType> violenceTypeList = violenceTypePersistenceGateway.findAll();

        Assertions.assertEquals(violenceTypes, violenceTypeList);
        Mockito.verify(violenceTypePersistenceGateway, Mockito.times(1)).findAll();
    }

    @Test
    void ShouldReturnAnEmptyListWhenDontFindViolenceType() {
        List<ViolenceType> violenceTypes = new ArrayList<>();

        List<ViolenceType> violenceTypeList = listVIolenceTypes.execute();

        Assertions.assertEquals(violenceTypes, violenceTypeList);
        Mockito.verify(violenceTypePersistenceGateway, Mockito.times(1)).findAll();
    }

}