package com.suavoz.report.controller;

import com.suavoz.report.controller.requests.ReportRequest;
import com.suavoz.report.controller.responses.ReportResponse;
import com.suavoz.report.domain.Report;
import com.suavoz.report.usecases.reportUseCases.CreateReport;
import com.suavoz.report.usecases.reportUseCases.DeleteReport;
import com.suavoz.report.usecases.reportUseCases.ListReports;
import com.suavoz.report.usecases.reportUseCases.UpdateReport;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final CreateReport createReport;
    private final UpdateReport updateReport;
    private final DeleteReport deleteReport;
    private final ListReports listReports;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ReportResponse createReport(@RequestBody ReportRequest reportRequest) {
        Report report = reportRequest.toDomain();
        Report savedReport = createReport.execute(report);
        return new ReportResponse(savedReport);
    }
}
