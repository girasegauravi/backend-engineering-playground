package com.designpatterns.behavioural.template;

public class Main {
    public static void main(String[] args) {

        ReportGenerator pdf = new PDFReportGenerator();
        pdf.generateReport();

        System.out.println();

        ReportGenerator csv = new CSVReportGenerator();
        csv.generateReport();
    }
}
