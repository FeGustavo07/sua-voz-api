package com.suavoz.report.usecases.report;

import com.suavoz.report.domain.Report;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.ReportPersistenceGateway;
import com.suavoz.report.validators.reportValidator.UpdateReportValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

@MockitoSettings
class UpdateReportTest {

    @InjectMocks
    UpdateReport updateReport;

    @Mock
    UpdateReportValidator updateReportValidator;

    @Mock
    ReportPersistenceGateway reportPersistenceGateway;

    @Test
    void ShouldUpdateReportIfValidationSucced() {
        Report report = Report.builder().build();
        Mockito.when(updateReportValidator.validate(report)).thenReturn(List.of());
        updateReport.execute(report);
        Assertions.assertDoesNotThrow(() -> ValidationExecption.class);
        Mockito.verify(reportPersistenceGateway, Mockito.times(1)).save(report);
    }

    @Test
    void ShouldNotUpdateIfValidationFailed() {
        Report report = Report.builder().build();
        Mockito.when(updateReportValidator.validate(report)).thenReturn(List.of("Errors"));
        Assertions.assertThrows(ValidationExecption.class, () -> updateReport.execute(report));
    }

}