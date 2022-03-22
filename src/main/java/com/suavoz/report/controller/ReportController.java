package com.suavoz.report.controller;

import com.suavoz.report.controller.requests.ReportRequest;
import com.suavoz.report.controller.responses.ReportResponse;
import com.suavoz.report.domain.Report;
import com.suavoz.report.usecases.reportUsecases.CreateReport;
import com.suavoz.report.usecases.reportUsecases.DeleteReport;
import com.suavoz.report.usecases.reportUsecases.ListReports;
import com.suavoz.report.usecases.reportUsecases.UpdateReport;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReportResponse updateReport(@PathVariable("id") Long id, @RequestBody ReportRequest reportRequest) {
        Report report = reportRequest.toDomain();
        report.setId(id);
        Report savedReport = updateReport.execute(report);
        return new ReportResponse(savedReport);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ReportResponse> listReports() {
        List<Report> reports = listReports.execute();
        return reports.stream().map(ReportResponse::new).collect(Collectors.toList());
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReport(@PathVariable("id") Long id) {
        Report report = Report.builder().build();
        report.setId(id);
        deleteReport.execute(report);
    }
}
