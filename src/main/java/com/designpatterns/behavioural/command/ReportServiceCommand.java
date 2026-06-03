package com.designpatterns.behavioural.command;

public class ReportServiceCommand implements Command {
    private final ReportService reportService;
    private final String reportName;

    public ReportServiceCommand(ReportService reportService, String reportName) {
        this.reportService = reportService;
        this.reportName = reportName;
    }

    public void execute() {
        reportService.generateReport(reportName);
    }
}
