package com.designpatterns.structural.proxy;

public class Main {
    public static void main(String[] args) {
        Report report = new ReportProxy("Monthly sales report");
        report.display();
        report.display();
    }
}
