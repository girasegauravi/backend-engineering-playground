package com.designpatterns.behavioural.template;

public class CSVReportGenerator extends ReportGenerator{
    @Override
    protected void exportReport() {
        System.out.println("Exporting CSV report");
    }
}
