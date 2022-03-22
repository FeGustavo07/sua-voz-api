package com.suavoz.report.usecases.report;


import com.suavoz.report.domain.Report;
import com.suavoz.report.gateways.persistence.ReportPersistenceGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.ArrayList;
import java.util.List;

@MockitoSettings
class ListReportsTest {

    @InjectMocks
    ListReports listReports;

    @Mock
    ReportPersistenceGateway reportPersistenceGateway;

    @Test
    void ShouldReturnAListWhenFindReports() {
        Report report = Report.builder().build();

        List<Report> reports = new ArrayList<>();

        reports.add(report);
        reports.add(report);

        Mockito.when(reportPersistenceGateway.findAll()).thenReturn(List.of(report, report));

        List<Report> reportList = reportPersistenceGateway.findAll();

        Assertions.assertEquals(reports, reportList);
        Mockito.verify(reportPersistenceGateway, Mockito.times(1)).findAll();
    }

    @Test
    void ShouldReturnAnEmptyListWhenDontFindReports() {
        List<Report> reports = new ArrayList<>();

        List<Report> reportList = listReports.execute();

        Assertions.assertEquals(reports, reportList);

        Mockito.verify(reportPersistenceGateway, Mockito.times(1)).findAll();
    }

}