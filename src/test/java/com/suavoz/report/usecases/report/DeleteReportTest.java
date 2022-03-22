package com.suavoz.report.usecases.report;

import com.suavoz.report.domain.Report;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.ReportPersistenceGateway;
import com.suavoz.report.validators.reportValidator.DeleteReportValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

@MockitoSettings
class DeleteReportTest {

    @InjectMocks
    DeleteReport deleteReport;

    @Mock
    DeleteReportValidator deleteReportValidator;

    @Mock
    ReportPersistenceGateway reportPersistenceGateway;

    @Test
    void ShouldDeleteWhenValidationSucceed() {
        Report report = Report.builder().build();
        Mockito.when(deleteReportValidator.validate(report)).thenReturn(List.of());
        deleteReport.execute(report);
        Mockito.verify(reportPersistenceGateway).delete(report);
    }

    @Test
    void ShouldThrowValidationExecptionWhenFailed() {
        Report report = Report.builder().build();
        Mockito.when(deleteReportValidator.validate(report)).thenReturn(List.of("Errors"));
        Assertions.assertThrows(ValidationExecption.class, () -> deleteReport.execute(report));
    }

}