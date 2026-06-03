package com.designpatterns.behavioural.template;

public class PDFReportGenerator extends ReportGenerator{
    @Override
    protected void exportReport() {
        System.out.println("Exporting PDF report");
    }
}
