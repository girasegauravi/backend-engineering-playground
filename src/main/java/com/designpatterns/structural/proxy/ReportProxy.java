package com.designpatterns.structural.proxy;


public class ReportProxy implements Report{
    RealReport report;
    String reportName;

    public ReportProxy(String reportName) {
        this.reportName = reportName;
    }

    @Override
    public void display() {
        if(report == null) {
            report = new RealReport(reportName);
        }
        report.display();
    }
}
