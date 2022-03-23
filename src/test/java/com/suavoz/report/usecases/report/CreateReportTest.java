package com.suavoz.report.usecases.report;

import com.suavoz.report.domain.Report;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.ReportPersistenceGateway;
import com.suavoz.report.validators.reportValidator.CreateReportValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

@MockitoSettings
class CreateReportTest {

    @InjectMocks
    CreateReport createReport;

    @Mock
    CreateReportValidator createReportValidator;

    @Mock
    ReportPersistenceGateway reportPersistenceGateway;

    @Test
    void ShouldSaveWhenValidationSucceed() {
        Report report = Report.builder().build();
        Mockito.when(createReportValidator.validate(report)).thenReturn(List.of());
        createReport.execute(report);
        Mockito.verify(reportPersistenceGateway).save(report);
    }

    @Test
    void ShouldReturnValidationExcpetionWhenValidationFailed() {
        Report report = Report.builder().build();
        Mockito.when(createReportValidator.validate(report)).thenReturn(List.of("validation errors"));
        Assertions.assertThrows(ValidationExecption.class, () -> createReport.execute(report));
    }

}