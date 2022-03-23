package com.suavoz.report.controllers;

import com.suavoz.report.controllers.requests.ReportRequest;
import com.suavoz.report.controllers.responses.ReportResponse;
import com.suavoz.report.domain.Report;
import com.suavoz.report.usecases.report.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final CreateReport createReport;
    private final UpdateReport updateReport;
    private final DeleteReport deleteReport;
    private final ListReports listReports;
    private final FindReportById findReportById;

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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ReportResponse> findReportById(@PathVariable("id") Long id) {
        Optional<Report> report = findReportById.execute(id);
        Optional<ReportResponse> savedReport = report.map(ReportResponse::new);
        return savedReport;
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReport(@PathVariable("id") Long id) {
        Report report = Report.builder().build();
        report.setId(id);
        deleteReport.execute(report);
    }
}
